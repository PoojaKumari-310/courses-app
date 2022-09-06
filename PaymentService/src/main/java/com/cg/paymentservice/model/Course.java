package com.cg.paymentservice.model;

public class Course {
	
	
		
		private long  courseId;
		
		private String  name;
		
		
		private String  description;
		
		private long fee;

		public long getCourseId() {
			return courseId;
		}

		public void setCourseId(long courseId) {
			this.courseId = courseId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public long getFee() {
			return fee;
		}

		public void setFee(long fee) {
			this.fee = fee;
		}

		public Course(long courseId, String name, String description, long fee) {
			super();
			this.courseId = courseId;
			this.name = name;
			this.description = description;
			this.fee = fee;
		}

		public Course() {
			super();
			
		}

		@Override
		public String toString() {
			return "Course [courseId=" + courseId + ", name=" + name + ", description=" + description + ", fee=" + fee
					+ "]";
		}
}







