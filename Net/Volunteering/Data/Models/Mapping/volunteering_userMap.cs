using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity.ModelConfiguration;

namespace Data.Models.Mapping
{
    public class volunteering_userMap : EntityTypeConfiguration<volunteering_user>
    {
        public volunteering_userMap()
        {
            // Primary Key
            this.HasKey(t => t.idUser);

            // Properties
            this.Property(t => t.DTYPE)
                .IsRequired()
                .HasMaxLength(31);

            this.Property(t => t.address)
                .HasMaxLength(255);

            this.Property(t => t.firstName)
                .HasMaxLength(255);

            this.Property(t => t.mailUser)
                .HasMaxLength(255);

            this.Property(t => t.password)
                .HasMaxLength(255);

            this.Property(t => t.type)
                .HasMaxLength(255);

            this.Property(t => t.userName)
                .HasMaxLength(255);

            this.Property(t => t.levelVolunteer)
                .HasMaxLength(255);

            this.Property(t => t.levelAdmin)
                .HasMaxLength(255);

            this.Property(t => t.addressAss)
                .HasMaxLength(255);

            this.Property(t => t.mailAss)
                .HasMaxLength(255);

            this.Property(t => t.nameAss)
                .HasMaxLength(255);

            // Table & Column Mappings
            this.ToTable("volunteering.user", "volunteering");
            this.Property(t => t.idUser).HasColumnName("idUser");
            this.Property(t => t.DTYPE).HasColumnName("DTYPE");
            this.Property(t => t.address).HasColumnName("address");
            this.Property(t => t.dateNaissance).HasColumnName("dateNaissance");
            this.Property(t => t.firstName).HasColumnName("firstName");
            this.Property(t => t.mailUser).HasColumnName("mailUser");
            this.Property(t => t.password).HasColumnName("password");
            this.Property(t => t.type).HasColumnName("type");
            this.Property(t => t.userName).HasColumnName("userName");
            this.Property(t => t.levelVolunteer).HasColumnName("levelVolunteer");
            this.Property(t => t.levelAdmin).HasColumnName("levelAdmin");
            this.Property(t => t.addressAss).HasColumnName("addressAss");
            this.Property(t => t.mailAss).HasColumnName("mailAss");
            this.Property(t => t.nameAss).HasColumnName("nameAss");
            this.Property(t => t.adminManage_idUser).HasColumnName("adminManage_idUser");
            this.Property(t => t.event_fk).HasColumnName("event_fk");
        }
    }
}
