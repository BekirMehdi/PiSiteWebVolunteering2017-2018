using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class productMap : EntityTypeConfiguration<product>
    {
        public productMap()
        {
            // Primary Key
            this.HasKey(t => t.ProductPk);

            // Properties
            this.Property(t => t.Description)
                .HasMaxLength(255);

            this.Property(t => t.Name)
                .HasMaxLength(255);

            this.Property(t => t.Image)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("product", "volunteering");
            this.Property(t => t.ProductPk).HasColumnName("ProductPk");
            this.Property(t => t.DateProd).HasColumnName("DateProd");
            this.Property(t => t.Description).HasColumnName("Description");
            this.Property(t => t.Name).HasColumnName("Name");
            this.Property(t => t.Price).HasColumnName("Price");
            this.Property(t => t.Quantity).HasColumnName("Quantity");
            this.Property(t => t.CategoryId).HasColumnName("CategoryId");
            this.Property(t => t.Image).HasColumnName("Image");
        }
    }
}
