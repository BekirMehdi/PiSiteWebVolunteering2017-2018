using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Data.Models
{
    public partial class category
    {
        public int CategoryId { get; set; }
        public string Name { get; set; }

        public virtual Collection<product> Products { get; set; }
    }
}
