using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Data.Models
{
    public class GroupModel
    {
        public int id { get; set; }
        public int Quantite { get; set; }
        public string Color { get; set; }
        public string Highlight { get; set; }
        public category CateogryName { get; set; }
    }
}
