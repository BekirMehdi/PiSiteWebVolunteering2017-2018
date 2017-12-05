using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class sponsor
    {
        public int idSponsor { get; set; }
        public Nullable<int> adminSponsors_idUser { get; set; }
    }
}
