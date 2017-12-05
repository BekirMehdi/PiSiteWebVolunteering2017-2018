namespace Data.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class v1 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "volunteering.category",
                c => new
                    {
                        idCategory = c.Int(nullable: false),
                        name = c.String(maxLength: 255, storeType: "nvarchar"),
                    })
                .PrimaryKey(t => t.idCategory);
            
            CreateTable(
                "volunteering.course",
                c => new
                    {
                        idCourse = c.Int(nullable: false, identity: true),
                        dateCreation = c.DateTime(precision: 0),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        nameCourse = c.String(maxLength: 255, storeType: "nvarchar"),
                        adminCourses_idUser = c.Int(),
                    })
                .PrimaryKey(t => t.idCourse);
            
            CreateTable(
                "volunteering.news",
                c => new
                    {
                        idNews = c.Int(nullable: false, identity: true),
                        dateCreation = c.DateTime(precision: 0),
                        description = c.String(maxLength: 255, storeType: "nvarchar"),
                        nameNews = c.String(maxLength: 255, storeType: "nvarchar"),
                        adminNews_idUser = c.Int(),
                    })
                .PrimaryKey(t => t.idNews);
            
            CreateTable(
                "volunteering.product",
                c => new
                    {
                        idProduct = c.Int(nullable: false),
                        name = c.String(maxLength: 255, storeType: "nvarchar"),
                        picture = c.String(maxLength: 255, storeType: "nvarchar"),
                        stock = c.Int(nullable: false),
                        unitCost = c.Double(),
                        category_fk = c.Int(),
                    })
                .PrimaryKey(t => t.idProduct);
            
            CreateTable(
                "volunteering.sponsor",
                c => new
                    {
                        idSponsor = c.Int(nullable: false, identity: true),
                        adminSponsors_idUser = c.Int(),
                    })
                .PrimaryKey(t => t.idSponsor);
            
            CreateTable(
                "volunteering.t_todo",
                c => new
                    {
                        id = c.Int(nullable: false, identity: true),
                        text = c.String(maxLength: 255, storeType: "nvarchar"),
                    })
                .PrimaryKey(t => t.id);
            
            CreateTable(
                "volunteering.user",
                c => new
                    {
                        idUser = c.Int(nullable: false, identity: true),
                        DTYPE = c.String(nullable: false, maxLength: 31, storeType: "nvarchar"),
                        address = c.String(maxLength: 255, storeType: "nvarchar"),
                        dateNaissance = c.DateTime(precision: 0),
                        firstName = c.String(maxLength: 255, storeType: "nvarchar"),
                        mailUser = c.String(maxLength: 255, storeType: "nvarchar"),
                        password = c.String(maxLength: 255, storeType: "nvarchar"),
                        type = c.String(maxLength: 255, storeType: "nvarchar"),
                        userName = c.String(maxLength: 255, storeType: "nvarchar"),
                        levelVolunteer = c.String(maxLength: 255, storeType: "nvarchar"),
                        levelAdmin = c.String(maxLength: 255, storeType: "nvarchar"),
                        addressAss = c.String(maxLength: 255, storeType: "nvarchar"),
                        mailAss = c.String(maxLength: 255, storeType: "nvarchar"),
                        nameAss = c.String(maxLength: 255, storeType: "nvarchar"),
                        adminManage_idUser = c.Int(),
                    })
                .PrimaryKey(t => t.idUser);
            
        }
        
        public override void Down()
        {
            DropTable("volunteering.user");
            DropTable("volunteering.t_todo");
            DropTable("volunteering.sponsor");
            DropTable("volunteering.product");
            DropTable("volunteering.news");
            DropTable("volunteering.course");
            DropTable("volunteering.category");
        }
    }
}
