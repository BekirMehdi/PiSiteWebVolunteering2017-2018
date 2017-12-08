using Data.Models;
using Service.Pattern;
using Data.Infrastructure;
using System.Collections.Generic;

namespace Services
{
    public class CategoryService : Service<category>
    {
        private static DatabaseFactory dbf = new DatabaseFactory();
        private static UnitOfWork utwk = new UnitOfWork(dbf);
        public CategoryService() : base(utwk)
        {

        }
    
    }
}
