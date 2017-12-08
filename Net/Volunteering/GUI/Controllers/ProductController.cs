using Data.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Services;
using System.IO;

namespace GUI.Controllers
{
    public class ProductController : Controller
    {
        ProductService ps = new ProductService();
        CategoryService cs = new CategoryService();
        // GET: Product
        public ActionResult Index()
        {
           // product p = Session["ProductSession"] as product;
            return View(ps.GetAll());
        }

        // GET: Product/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Product/Create
        public ActionResult Create()
        {
            ViewBag.category = new SelectList(cs.GetAll(), "CategoryId", "Name");
            return View();
        }

        // POST: Product/Create
        [HttpPost]
        public ActionResult Create(product p)
        {
    
            try
            {
                //p.picture = Imag.FileName;
                // Imag.SaveAs(Path.Combine(Server.MapPath("~/Content/"), Imag.FileName));

                //  Session["ProductSession"] = p;
                // TODO: Add insert logic here
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
            return View();
        }

        // POST: Product/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

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
            return View();
        }

        // POST: Product/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
