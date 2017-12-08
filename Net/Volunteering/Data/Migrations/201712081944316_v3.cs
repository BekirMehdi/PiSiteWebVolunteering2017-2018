namespace Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class v3 : DbMigration
    {
        public override void Up()
        {
            DropColumn("volunteering.product", "DateProd");
        }
        
        public override void Down()
        {
            AddColumn("volunteering.product", "DateProd", c => c.DateTime(nullable: false, precision: 0));
        }
    }
}
