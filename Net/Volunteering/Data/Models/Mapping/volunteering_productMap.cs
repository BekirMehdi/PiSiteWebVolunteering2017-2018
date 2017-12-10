using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class volunteering_productMap : EntityTypeConfiguration<volunteering_product>
    {
        public volunteering_productMap()
        {
            // Primary Key
            this.HasKey(t => t.ProductPk);

            // Properties
            this.Property(t => t.ProductPk)
                .HasDatabaseGeneratedOption(DatabaseGeneratedOption.None);

            this.Property(t => t.Description)
                .HasMaxLength(255);

            this.Property(t => t.Name)
                .IsRequired()
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("volunteering.product", "volunteering");
            this.Property(t => t.ProductPk).HasColumnName("ProductPk");
            this.Property(t => t.Description).HasColumnName("Description");
            this.Property(t => t.Name).HasColumnName("Name");
            this.Property(t => t.Price).HasColumnName("Price");
            this.Property(t => t.Quantity).HasColumnName("Quantity");
            this.Property(t => t.CategoryId).HasColumnName("CategoryId");
            this.Property(t => t.DateProd).HasColumnName("DateProd");

            // Relationships
            this.HasOptional(t => t.volunteering_category)
                .WithMany(t => t.volunteering_product)
                .HasForeignKey(d => d.CategoryId);

        }
    }
}
