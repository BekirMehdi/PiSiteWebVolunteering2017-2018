using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class user
    {
        public string DTYPE { get; set; }
        public int idUser { get; set; }
        public string address { get; set; }
        public Nullable<System.DateTime> dateNaissance { get; set; }
        public string firstName { get; set; }
        public string mailUser { get; set; }
        public string password { get; set; }
        public string type { get; set; }
        public string userName { get; set; }
        public string levelVolunteer { get; set; }
        public string levelAdmin { get; set; }
        public string addressAss { get; set; }
        public string mailAss { get; set; }
        public string nameAss { get; set; }
        public Nullable<int> adminManage_idUser { get; set; }
        public Nullable<int> event_fk { get; set; }
    }
}
