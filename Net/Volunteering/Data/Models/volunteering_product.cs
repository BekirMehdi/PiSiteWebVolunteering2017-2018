using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_product
    {
        public int ProductPk { get; set; }
        public string Description { get; set; }
        public string Name { get; set; }
        public double Price { get; set; }
        public int Quantity { get; set; }
        public Nullable<int> CategoryId { get; set; }
        public System.DateTime DateProd { get; set; }
        public virtual volunteering_category volunteering_category { get; set; }
    }
}
