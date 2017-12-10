using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_sponsor
    {
        public int idSponsor { get; set; }
        public Nullable<int> adminSponsors_idUser { get; set; }
    }
}
