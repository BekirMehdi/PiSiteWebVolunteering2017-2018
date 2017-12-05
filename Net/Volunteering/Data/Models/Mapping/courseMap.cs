using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class courseMap : EntityTypeConfiguration<course>
    {
        public courseMap()
        {
            // Primary Key
            this.HasKey(t => t.idCourse);

            // Properties
            this.Property(t => t.description)
                .HasMaxLength(255);

            this.Property(t => t.nameCourse)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("course", "volunteering");
            this.Property(t => t.idCourse).HasColumnName("idCourse");
            this.Property(t => t.dateCreation).HasColumnName("dateCreation");
            this.Property(t => t.description).HasColumnName("description");
            this.Property(t => t.nameCourse).HasColumnName("nameCourse");
            this.Property(t => t.adminCourses_idUser).HasColumnName("adminCourses_idUser");
        }
    }
}
