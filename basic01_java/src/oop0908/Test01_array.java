package oop0908;

public class Test01_array {

	public static void main(String[] args) {

		Score kim = new Score("김", 10, 20, 30);
		Score lee = new Score("이", 40, 50, 60);
		Score park = new Score("박", 70, 80, 90);
		
		kim.calc();
		lee.calc();
		park.calc();
		
		//객체배열
		Score[] score = {new Score("김",10,20,30)
				  		,new Score("이", 40, 50, 60)
				  		,new Score("박", 70, 80, 90)
				  	  };
		
//		score[0].calc();
//		score[1].calc();
//		score[2].calc();
		
//		score[0].disp();
//		score[1].disp();
//		score[2].disp();
		
		int size = score.length; //3
		
		for(int i=0; i<size; i++) {
			score[i].calc();
			score[i].disp();
		}
	}

}
