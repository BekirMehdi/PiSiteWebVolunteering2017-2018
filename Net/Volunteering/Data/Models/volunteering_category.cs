using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_category
    {
        public volunteering_category()
        {
            this.volunteering_product = new List<volunteering_product>();
        }

        public int CategoryId { get; set; }
        public string Name { get; set; }
        public virtual ICollection<volunteering_product> volunteering_product { get; set; }
    }
}
