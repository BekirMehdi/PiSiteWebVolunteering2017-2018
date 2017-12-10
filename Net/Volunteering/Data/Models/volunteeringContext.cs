using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using Data.Models.Mapping;

namespace Data.Models
{
    public partial class volunteeringContext : DbContext
    {
        static volunteeringContext()
        {
            Database.SetInitializer<volunteeringContext>(null);
        }

        public volunteeringContext()
            : base("Name=volunteeringContext")
        {
        }

        public DbSet<category> categories { get; set; }
        public DbSet<course> courses { get; set; }
        public DbSet<evenement> evenements { get; set; }
        public DbSet<news> news { get; set; }
        public DbSet<product> products { get; set; }
        public DbSet<sponsor> sponsors { get; set; }
        public DbSet<t_todo> t_todo { get; set; }
        public DbSet<user> users { get; set; }
        public DbSet<volunteering_category> volunteering_category { get; set; }
        public DbSet<volunteering_course> volunteering_course { get; set; }
        public DbSet<volunteering_evenement> volunteering_evenement { get; set; }
        public DbSet<volunteering_news> volunteering_news { get; set; }
        public DbSet<volunteering_product> volunteering_product { get; set; }
        public DbSet<volunteering_sponsor> volunteering_sponsor { get; set; }
        public DbSet<volunteering_t_todo> volunteering_t_todo { get; set; }
        public DbSet<volunteering_user> volunteering_user { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new categoryMap());
            modelBuilder.Configurations.Add(new courseMap());
            modelBuilder.Configurations.Add(new evenementMap());
            modelBuilder.Configurations.Add(new newsMap());
            modelBuilder.Configurations.Add(new productMap());
            modelBuilder.Configurations.Add(new sponsorMap());
            modelBuilder.Configurations.Add(new t_todoMap());
            modelBuilder.Configurations.Add(new userMap());
            modelBuilder.Configurations.Add(new volunteering_categoryMap());
            modelBuilder.Configurations.Add(new volunteering_courseMap());
            modelBuilder.Configurations.Add(new volunteering_evenementMap());
            modelBuilder.Configurations.Add(new volunteering_newsMap());
            modelBuilder.Configurations.Add(new volunteering_productMap());
            modelBuilder.Configurations.Add(new volunteering_sponsorMap());
            modelBuilder.Configurations.Add(new volunteering_t_todoMap());
            modelBuilder.Configurations.Add(new volunteering_userMap());
        }
    }
}
