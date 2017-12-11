using Data.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Services;
using System.IO;
using System.Dynamic;
using System.Drawing.Printing;
using PagedList;


namespace GUI.Controllers
{
    public class ProductController : Controller
    {
        ProductService ps = new ProductService();
        CategoryService cs = new CategoryService();


        // GET: ProductCtegory
        public ActionResult IndexFront()
        {
            List<GroupModel> listG = new List<GroupModel>();
            listG=ps.getQuantiteProdByCat();
            int pageSize = 9;
            int pageNumber = 1;
            dynamic mymodel = new ExpandoObject();
            ViewBag.Message = "Welcome to my demo!";
            mymodel.products = ps.GetAll().ToPagedList(pageNumber, pageSize);
            mymodel.categories = cs.GetAll();
            mymodel.groupModels = listG;

            return View(mymodel);
        }
        public ActionResult ProductByCategory(int categoryId)
        {


            int pageSize = 3;
            int pageNumber = 1;
            dynamic mymodel = new ExpandoObject();
            ViewBag.Message = "Welcome to my demo!";
        
                List<product> lstC = new List<product>();
                lstC = ps.GetAll().Where(e => e.CategoryId == categoryId).ToList();
                mymodel.products = lstC.ToPagedList(pageNumber, pageSize);
            mymodel.categories = cs.GetAll();

            return View(mymodel);
        }
        // POST: ProductCtegory/
        [HttpPost]
        public ActionResult IndexFront(string search)
        {
            List<product> lstC = new List<product>();

            if (search == null)
            {
                lstC = ps.GetAll().ToList();
            }

            else
            {
                lstC = ps.GetAll().Where(e => e.Name.Contains(search)).ToList();
            }

            ViewBag.Message = "Welcome to my demo!";
            dynamic mymodel = new ExpandoObject();
            mymodel.products = lstC;
            mymodel.categories = cs.GetAll();
            return View(mymodel);

        }

       

        // GET: Product
        public ActionResult Index(int? page)
        {
            int pageSize = 3;
            int pageNumber = (page ?? 1);
           // PagedList<product> model = new PagedList<product>(ps.GetAll(), page, pageSize);
            return View(ps.GetAll().ToPagedList(pageNumber, pageSize));
        }

        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            var category = cs.GetAll().Where(e => e.CategoryId == ps.GetById(id).CategoryId).ToList();
            dynamic mymodel = new ExpandoObject();
            ViewBag.Message = "Welcome to my demo!";
            mymodel.product = ps.GetAll().Where(e => e.ProductPk == id).ToList();
            mymodel.products = ps.GetAll().Where(e => e.CategoryId== ps.GetById(id).CategoryId).ToList();
            mymodel.category = category;


            return View(mymodel);
        }

        // GET: Product/Create
        public ActionResult Create()
        {
            ViewBag.category = new SelectList(cs.GetAll(), "CategoryId", "Name");
            return View();
        }

        // POST: Product/Create
        [HttpPost]
        public ActionResult Create(product p, HttpPostedFileBase Imag)
        {
    
            try
            {
                p.Image = Imag.FileName;
                Imag.SaveAs(Path.Combine(Server.MapPath("~/Content/"), Imag.FileName));
                p.DateProd = DateTime.Now;
                ps.Add(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Product/Edit/5
        public ActionResult Edit(int id)
        {
            ViewBag.category = new SelectList(cs.GetAll(), "CategoryId", "Name");
            return View(ps.Get(e => e.ProductPk == id));
        }

        // POST: Product/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, product prod, HttpPostedFileBase Imag)
        {
            try
            {
                // TODO: Add update logic here

            
                Imag.SaveAs(Path.Combine(Server.MapPath("~/Content/"), Imag.FileName));
                product p = new product();
               
                p = ps.GetById(id);
                p.Image = Imag.FileName;
                p.DateProd = prod.DateProd;
                p.Name = prod.Name;
                p.Description = p.Description;
                p.Price = prod.Price;
                p.Quantity = prod.Quantity;
                p.CategoryId = p.CategoryId;
                ps.Update(p);
                ps.Commit();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }

        }

        // GET: Product/Delete/5
        public ActionResult Delete(int id)
        {
            product p = ps.GetById(id);
            return View(p);
        }

        // POST: Product/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, product p)
        {
            try
            {
                // TODO: Add delete logic here
                p = ps.GetById(id);
                ps.Delete(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

    }
}
