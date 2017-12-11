using Data.Infrastructure;
using Data.Models;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class ProductService : Service<product>
    {
        int i = 0;
        private static DatabaseFactory df = new DatabaseFactory();
        private static UnitOfWork uf = new UnitOfWork(df);
        private Random rnd = new Random();
        public ProductService() : base(uf)
        {


        }
        // public IEnumerable<product> getProdById(int id)
        // {
        //
        //    return uf.getRepository<product>().GetAll().Where(e => e.CategoryId == id);
        // }
        public List<GroupModel> getQuantiteProdByCat()
        {
            /*  var productListResult = uf.getRepository<product>().GetAll()
          .GroupBy(pv => pv.ProductPk)
          .Select(g => new
          {
              Product = g.Key,
              TotalOrderCount = g.Count(),
              TotalSales = g.Sum(pv => pv.Price),
              TotalQuantity = g.Sum(pv => pv.Quantity),
          })
          .OrderByDescending(x => x.TotalOrderCount).ToList();*/


            /* foreach (var line in uf.getRepository<product>().GetAll().GroupBy(info => info.CategoryId)
                          .Select(group => new {
                              Metric = group.Key,
                              Count = group.Count()
                          })
                          .OrderBy(x => x.Metric)
  {
                 Console.WriteLine("{0} {1}", line.Metric, line.Count);
             }*/

            var query = from p in uf.getRepository<product>().GetAll()
                        join c in uf.getRepository<category>().GetAll() on p.CategoryId equals c.CategoryId into e
                        from j in e.DefaultIfEmpty()
                        group p by p.CategoryId into g
                        select new GroupModel
                        {
                            id= i++,
                            Color = String.Format("#{0:X6}", rnd.Next(0x1000000)),
                            Highlight = String.Format("#{0:X6}", rnd.Next(0x1000000)),
                            Quantite = g.ToList().Count(),
                            CateogryName = uf.getRepository<category>().GetAll().Where(e => e.CategoryId == g.First().CategoryId).Single()
                        };
            return query.ToList();
        }

    }
}

