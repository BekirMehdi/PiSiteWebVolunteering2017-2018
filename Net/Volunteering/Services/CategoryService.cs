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
    public class CategoryService : Service<category>
    {
        private static DatabaseFactory dbf = new DatabaseFactory();
        private static UnitOfWork uof = new UnitOfWork(dbf);
        public CategoryService() : base(uof)
        {

        }
    
    }
}
