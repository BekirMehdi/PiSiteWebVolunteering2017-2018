using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class volunteering_t_todoMap : EntityTypeConfiguration<volunteering_t_todo>
    {
        public volunteering_t_todoMap()
        {
            // Primary Key
            this.HasKey(t => t.id);

            // Properties
            this.Property(t => t.text)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("volunteering.t_todo", "volunteering");
            this.Property(t => t.id).HasColumnName("id");
            this.Property(t => t.text).HasColumnName("text");
        }
    }
}
