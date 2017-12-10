using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_news
    {
        public int idNews { get; set; }
        public Nullable<System.DateTime> dateCreation { get; set; }
        public string description { get; set; }
        public string nameNews { get; set; }
        public Nullable<int> adminNews_idUser { get; set; }
    }
}
