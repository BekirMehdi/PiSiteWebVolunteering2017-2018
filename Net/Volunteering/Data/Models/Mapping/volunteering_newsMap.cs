using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class volunteering_newsMap : EntityTypeConfiguration<volunteering_news>
    {
        public volunteering_newsMap()
        {
            // Primary Key
            this.HasKey(t => t.idNews);

            // Properties
            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.nameNews)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("volunteering.news", "volunteering");
            this.Property(t => t.idNews).HasColumnName("idNews");
            this.Property(t => t.dateCreation).HasColumnName("dateCreation");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.nameNews).HasColumnName("nameNews");
            this.Property(t => t.adminNews_idUser).HasColumnName("adminNews_idUser");
        }
    }
}
