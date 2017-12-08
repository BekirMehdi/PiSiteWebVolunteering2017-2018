using Data.Models;
using Service.Pattern;
using Data.Infrastructure;
using System.Collections.Generic;
using System.Linq;
namespace Services
{
    public class ProductService : Service<product>
    {
        private static DatabaseFactory df= new DatabaseFactory();
        private static UnitOfWork utwk = new UnitOfWork(df);


        public ProductService() : base(utwk)
        {

        }
        public IEnumerable<product> getProdById(int id)
        {

            return utwk.getRepository<product>().GetAll().Where(e => e.category_fk == id);
        }


    }
}

