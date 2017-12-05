using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class product
    {
        public int idProduct { get; set; }
        public string name { get; set; }
        public string picture { get; set; }
        public int stock { get; set; }
        public Nullable<double> unitCost { get; set; }
        public Nullable<int> category_fk { get; set; }
    }
}
