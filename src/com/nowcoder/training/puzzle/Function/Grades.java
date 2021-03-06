//Grades.java
package com.nowcoder.training.puzzle.Function;
import com.nowcoder.training.puzzle.Game.Puzzle;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import com.nowcoder.training.puzzle.Arg.Arg;
class Data
{
	public String name;
	public int time;
	public int step;
}
public class Grades
{
	private Puzzle app;
	private Data [] data = {
		new Data(),
		new Data(),
		new Data()
	};
	public Grades(Puzzle m)
	{
		app = m;
	}
	private void creatData()
	{
		try
		{
			File file = new File(Arg.rc);
			if (file.exists())
				return;
			file.createNewFile();
			PrintStream fout = new PrintStream(Arg.rc);
			fout.printf("%s %d %d\n", "(●'◡'●)",888888, 666666);
			fout.printf("%s %d %d\n", "(￣▽￣)\"",777777, 444444);
			fout.printf("%s %d %d\n", "(～￣▽￣～)",555555, 566666);
			fout.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, Arg.rc + " has broken!");
			return;
		}
	}
	private void readData()
	{
		try
		{
			File file = new File(Arg.rc);
			Scanner cin = new Scanner(file);
			data[0].name = cin.next();
			data[0].time = cin.nextInt();
			data[0].step = cin.nextInt();
			data[1].name = cin.next();
			data[1].time = cin.nextInt();
			data[1].step = cin.nextInt();
			data[2].name = cin.next();
			data[2].time = cin.nextInt();
			data[2].step = cin.nextInt();
		
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, Arg.rc + " can't read!");
		}
	}

	public void set(int t, int s)
	{
		int type = app.gettype();
		creatData();
		readData();
		if (t > data[type].time || (t == data[type].time && s >= data[type].step))
			return;
		data[type].name = JOptionPane.showInputDialog(null,"你打破了记录!\n请输入你的名字。");
		data[type].time = t;
		data[type].step = s;
		try
		{
			PrintStream f = new PrintStream(Arg.rc);
			f.printf("%s %d %d\n", data[0].name, data[0].time, data[0].step);
			f.printf("%s %d %d\n", data[1].name, data[1].time, data[1].step);
			f.printf("%s %d %d\n", data[2].name, data[2].time, data[2].step);
			f.close();
			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, Arg.rc + " has broken!");
		}
		show();
		app.dispose();
		app=new Puzzle();
	}

	public void show()
	{
		try
		{
			creatData();
			readData();
			String title = "".format("%8s%15s%8s%8s\n", "等级", "姓名", "时间", "步数");
			String h = "".format("%8s%15s%8d%8d\n", "困难", data[0].name, data[0].time, data[0].step);
			String n = "".format("%8s%15s%8d%8d\n", "普通", data[1].name, data[1].time, data[1].step);
			String e = "".format("%8s%15s%8d%8d\n", "简单", data[2].name, data[2].time, data[2].step);
			JOptionPane.showMessageDialog(null, title+h+n+e);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, Arg.rc + " has broken!");
		}
	}
}
