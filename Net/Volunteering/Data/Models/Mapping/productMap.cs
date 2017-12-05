using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class productMap : EntityTypeConfiguration<product>
    {
        public productMap()
        {
            // Primary Key
            this.HasKey(t => t.idProduct);

            // Properties
            this.Property(t => t.idProduct)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.name)
                .HasMaxLength(255);

            this.Property(t => t.picture)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("product", "volunteering");
            this.Property(t => t.idProduct).HasColumnName("idProduct");
            this.Property(t => t.name).HasColumnName("name");
            this.Property(t => t.picture).HasColumnName("picture");
            this.Property(t => t.stock).HasColumnName("stock");
            this.Property(t => t.unitCost).HasColumnName("unitCost");
            this.Property(t => t.category_fk).HasColumnName("category_fk");
        }
    }
}
