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
        public DbSet<news> news { get; set; }
        public DbSet<product> products { get; set; }
        public DbSet<sponsor> sponsors { get; set; }
        public DbSet<t_todo> t_todo { get; set; }
        public DbSet<user> users { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new categoryMap());
            modelBuilder.Configurations.Add(new courseMap());
            modelBuilder.Configurations.Add(new newsMap());
            modelBuilder.Configurations.Add(new productMap());
            modelBuilder.Configurations.Add(new sponsorMap());
            modelBuilder.Configurations.Add(new t_todoMap());
            modelBuilder.Configurations.Add(new userMap());
        }
    }
}
