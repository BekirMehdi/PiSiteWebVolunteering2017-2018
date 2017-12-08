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
    class UserSerices : Service<user>
    {

        private static DatabaseFactory df = new DatabaseFactory();
        private static UnitOfWork uf = new UnitOfWork(df);
        public UserSerices() : base(uf)
        {


        }


        public IEnumerable<user> ChemicalClient()
        {
            IEnumerable<user> ListCl = uf.getRepository<user>().GetAll();
            IEnumerable<product> ListP = uf.getRepository<product>().GetAll();

            List<user> ListRet = new List<user>();

            foreach (var lc in ListCl)
            {
                
           
                        foreach (var lp in ListP)
                        {
                            
                            user cc = lc;
                               ListRet.Add(cc);
                            
                        }
                    
                

            }
            return ListRet;

        }

    }
}
