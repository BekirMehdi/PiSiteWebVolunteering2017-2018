using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_evenement
    {
        public int idEvent { get; set; }
        public string address { get; set; }
        public Nullable<System.DateTime> dateEvent { get; set; }
        public string description { get; set; }
        public string imgPath { get; set; }
        public string latitude { get; set; }
        public string longitude { get; set; }
        public string mailResp { get; set; }
        public string nameEvent { get; set; }
        public int phoneResp { get; set; }
        public string typeEvent { get; set; }
    }
}
