using Data.Infrastructure;
using Data.Models;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class ProductService : Service<product>
    {
        private static DatabaseFactory df = new DatabaseFactory();
        private static UnitOfWork uf = new UnitOfWork(df);
        public ProductService() : base(uf)
        {


        }
       // public IEnumerable<product> getProdById(int id)
       // {
//
        //    return uf.getRepository<product>().GetAll().Where(e => e.CategoryId == id);
       // }


    }
}

