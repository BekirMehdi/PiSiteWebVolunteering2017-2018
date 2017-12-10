using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class volunteering_sponsorMap : EntityTypeConfiguration<volunteering_sponsor>
    {
        public volunteering_sponsorMap()
        {
            // Primary Key
            this.HasKey(t => t.idSponsor);

            // Properties
            // Table & Column Mappings
            this.ToTable("volunteering.sponsor", "volunteering");
            this.Property(t => t.idSponsor).HasColumnName("idSponsor");
            this.Property(t => t.adminSponsors_idUser).HasColumnName("adminSponsors_idUser");
        }
    }
}
