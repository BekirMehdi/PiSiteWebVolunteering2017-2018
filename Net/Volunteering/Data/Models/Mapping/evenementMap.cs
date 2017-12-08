using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class evenementMap : EntityTypeConfiguration<evenement>
    {
        public evenementMap()
        {
            // Primary Key
            this.HasKey(t => t.idEvent);

            // Properties
            this.Property(t => t.idEvent)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.address)
                .HasMaxLength(255);

            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.imgPath)
                .HasMaxLength(255);

            this.Property(t => t.latitude)
                .HasMaxLength(255);

            this.Property(t => t.longitude)
                .HasMaxLength(255);

            this.Property(t => t.mailResp)
                .HasMaxLength(255);

            this.Property(t => t.nameEvent)
                .HasMaxLength(255);

            this.Property(t => t.typeEvent)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("evenement", "volunteering");
            this.Property(t => t.idEvent).HasColumnName("idEvent");
            this.Property(t => t.address).HasColumnName("address");
            this.Property(t => t.dateEvent).HasColumnName("dateEvent");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.imgPath).HasColumnName("imgPath");
            this.Property(t => t.latitude).HasColumnName("latitude");
            this.Property(t => t.longitude).HasColumnName("longitude");
            this.Property(t => t.mailResp).HasColumnName("mailResp");
            this.Property(t => t.nameEvent).HasColumnName("nameEvent");
            this.Property(t => t.phoneResp).HasColumnName("phoneResp");
            this.Property(t => t.typeEvent).HasColumnName("typeEvent");
        }
    }
}
