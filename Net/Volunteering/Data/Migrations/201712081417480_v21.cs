namespace Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class v21 : DbMigration
    {
        public override void Up()
        {
            AlterColumn("volunteering.product", "DateProd", c => c.DateTime(nullable: false, precision: 0));
            AlterColumn("volunteering.product", "Name", c => c.String(nullable: false, maxLength: 255, storeType: "nvarchar"));
        }
        
        public override void Down()
        {
            AlterColumn("volunteering.product", "Name", c => c.String(maxLength: 255, storeType: "nvarchar"));
            AlterColumn("volunteering.product", "DateProd", c => c.DateTime(precision: 0));
        }
    }
}
