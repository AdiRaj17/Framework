package com.techlist.WebTable;

import java.util.HashSet;

import org.testng.annotations.Test;

public class JavaProgrammes {
	@Test
	public void JavaProgrammes(){
	String [] subject = {"Java","C","Java","C"};
	String [] name = {"Adi","Aditya","Richa","Ruchi","Adi"};
	String sen = "My name is aditya";
	String concat = "Engg.";
			
	/*//Length of a String
	System.out.println("The length of the string is : " +sen.length());
	
	//Value present at particular index
	System.out.println("The character present at index is : " +sen.charAt(5));
	
	//Find particular index
	System.out.println("The index of particular char is : " +sen.indexOf("i"));
	System.out.println("The index of particular char is from given index : " +sen.indexOf("i", 9));
	System.out.println("The index of particular char is from given index : " +sen.indexOf("i", sen.indexOf("i")+1));
	
	//Concat given String
	System.out.println("The concated syring is : " +sen.concat(" "+concat));
	
	//Contains give string
	System.out.println("The string contains : " +sen.contains("xc"));
		
	//Substring of a given String
	System.out.println("The sub string contains : " +sen.substring(5));
	System.out.println("The sub string contains : " +sen.substring(1, 5));
	System.out.println("The string contains : " +sen.subSequence(1, 5));
	
	//Replace to replace spaces between words of a sentence 
	//trim only replaces before and after spaces
	System.out.println("The replace string is : " +sen.replace(" ", ""));
	System.out.println("The replace string is : " +sen.replace(" ", "-"));*/
	
	
	/*//Find duplicate elements in an Array
	HashSet<String> set= new HashSet<String>();
	for(String s : name)
	{
		if(set.add(s)==false) {
			System.out.println("Duplicate subject is : " +s);
		}
	}*/
	
	//Print  duplicate character of a String
	/*String mname = "aditya";
	char [] ch = mname.toCharArray();
	//int count =0;
	for(int i=0;i<ch.length-1;i++) {
		for(int j=i+1;j<ch.length;j++)
		{
			if(ch[i]==ch[j])
			{
				//count++;
				System.out.println("Duplicate character is : " +ch[j]);	
			}
		}
	}*/
	
	//------------------------------------------------------------
	//Value of and parseInt method
	/*int a =10;
	int b=20;
	String ab="95";
	String s=String.valueOf(a);
	System.out.println(a+s);
	//int c= Integer.parseInt(ab);
	//System.out.println(c);
	Integer n=Integer.valueOf(ab);
	System.out.println("Value"+n);
	*/
	//------------------------------------------------------------
	//Pattern print
	/*int row=4;
	for(int i=1;i<=row;i++)
	{
		for(int j=1;j<=i;j++) {
			System.out.print("*");
		}
		System.out.println("");
	}
	for(int m=1;m<=row-1;m++) { {
			for(int k=row-1;k>=m;k--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}*/
	
	
	/*int i,j,row=3;
	for(i=1;i<=row;i++)
	{
		for(j=1;j<=i;j++) {
			if((i+j)%2==0)
			System.out.print("1"+ " ");
			else
			 System.out.print("0"+ " ");	
		}
		System.out.println("");
	}*/
//------------------------------------------------------------------------------------	
	/*int i,j,row=3;
	for(i=1;i<=row;i++)
	{
		for(j=1;j<=i;j++) {
			System.out.print(j+i+ " ");
		}
		System.out.println("");
	}*/
	
	//------------------------------------------------------------------------------------	
		int i,j,row=5;
		for(i=1;i<=row;i++)
		{
			for(j=row-i;j>=1;j--) {
				System.out.print(" ");
			}
			if(i==1 && i==5) {
			for(int k=1;k<=i;k++) {
				System.out.print("*"+" " );
			}
			}
			else
				for(int m=0;m<2;m++)
				{
					System.out.print("*"+" " );
				}
			
			System.out.println("");
		}
 }
}


