using System;
using System.Collections.Generic;

namespace Data.Models
{
    public partial class volunteering_course
    {
        public int idCourse { get; set; }
        public Nullable<System.DateTime> dateCreation { get; set; }
        public string description { get; set; }
        public string nameCourse { get; set; }
        public Nullable<int> adminCourses_idUser { get; set; }
    }
}
