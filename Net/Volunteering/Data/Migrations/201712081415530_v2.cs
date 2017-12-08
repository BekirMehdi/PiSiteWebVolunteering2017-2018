namespace Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class v2 : DbMigration
    {
        public override void Up()
        {
            CreateIndex("volunteering.product", "CategoryId");
            AddForeignKey("volunteering.product", "CategoryId", "volunteering.category", "CategoryId");
        }
        
        public override void Down()
        {
            DropForeignKey("volunteering.product", "CategoryId", "volunteering.category");
            DropIndex("volunteering.product", new[] { "CategoryId" });
        }
    }
}
