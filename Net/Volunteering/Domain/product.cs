using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Xml.Linq;

namespace Data.Models
{
    public partial class product
    {
        [Display(Name = "Production Date")]
        [DataType(DataType.DateTime)]


        public DateTime DateProd { get; set; }
        [DataType(DataType.MultilineText)]
        public string Description { get; set; }
        [Required(ErrorMessage = "msg")]
        [StringLength(25)]
        [MaxLength(50)]


        public string Name { get; set; }
        [DataType(DataType.Currency)]
        public double Price { get; set; }
        [Key]
        public int ProductPk { get; set; }
        [Range(0, int.MaxValue)]
        public int Quantity { get; set; }
        public int? CategoryId { get; set; }
        [ForeignKey("CategoryId")]
        public virtual category Cat { get; set; }

        public string Image { get; set; }
    }
}
