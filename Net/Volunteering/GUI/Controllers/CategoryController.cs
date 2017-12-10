using Data.Models;
using Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace GUI.Controllers
{
    public class CategoryController : Controller
    {
        CategoryService cs = new CategoryService();
        ProductService ps = new ProductService();
        // GET: Category
        public ActionResult Index()
        {
            return View(cs.GetAll());
        }

        // GET: Category/Details/5
        public ActionResult Details(int id)
        {
            category c = cs.GetById(id);
            return View(c);
        }

        // GET: Category/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Category/Create
        [HttpPost]
        public ActionResult Create(category c)
        {

            try
            {
                cs.Add(c);
                cs.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Category/Edit/5
        public ActionResult Edit(int id)
        {
            return View(cs.Get(e => e.CategoryId == id));
        }

        // POST: Category/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, category cat)
        {

            try
            {
                // TODO: Add update logic here

                category c = new category();
                c = cs.GetById(id);
                c.CategoryId = cat.CategoryId;
                c.Name = cat.Name;
              
                cs.Update(c);
                cs.Commit();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Category/Delete/5
        public ActionResult Delete(int id)
        {
            category c = cs.GetById(id);
            return View(c);
        }

        // POST: Category/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, category c)
        {
            try
            {
                // TODO: Add delete logic here
                c = cs.GetById(id);
                cs.Delete(c);
                cs.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
