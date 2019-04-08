import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/*<applet code=Fourr width=500 height=500></applet>*/
public class Fourr extends Applet implements KeyListener
{
Random r;
int[][] a;
int x,y;
int p,b,g=0;
Label[][] lb;
int status,xi,yi;
Font f;
public void init()
{
xi=yi=0;
status=0;
setLayout(null);
lb=new Label[4][4];
a=new int[4][4];
r=new Random();
f=new Font("Times New Roman",Font.BOLD,36);
for(int i=0;i<=3;i++)
{
for(int j=0;j<=3;j++)
{
lb[i][j]=new Label("",Label.CENTER);
position(i,j);
lb[i][j].setBounds(x+7,y+7,75,65);
add(lb[i][j]);
}
}
generate(2);
lb[xi][yi].setText("2");
lb[xi][yi].setFont(f);

setFocusable(true);
requestFocusInWindow();
//while(!hasFocus)
//focusApplet();

addKeyListener(this);
}

public void position(int i,int j)
{
switch(j)
{
case 0:
x=50;
break;
case 1:
x=137;
break;
case 2:
x=224;
break;
case 3:
x=311;
break;
}
switch(i)
{
case 0:
y=100;
break;
case 1:
y=175;
break;
case 2:
y=250;
break;
case 3:
y=325;
break;
}
}

void four()
{
int s=0,q=0;
status=0;
b=(r.nextInt(2)+1)*2;
for(s=0;s<4;s++)
{
for(q=0;q<4;q++)
{
if(a[s][q]==0)
break;
}
if(q<4)
break;
}
if(s>=4)
 {
  System.out.println("Play Again");
  JOptionPane.showMessageDialog(null,"Game Over!!","2048",JOptionPane.ERROR_MESSAGE);
 }
if(g==1)
 {
 while(status==0)
  generate(b); //end while
 lb[xi][yi].setText(Integer.toString(b));
 lb[xi][yi].setFont(f);
}
}

void generate(int b)
{
p=r.nextInt(16); //generates random numbers from 0 to 15
switch(p)
{
case 0:
if(a[0][0]==0)
{
x=50;
y=100;
a[0][0]=b;
xi=0;
yi=0;
status=1;
} 
break;

case 1:
if(a[0][1]==0)
{
x=137;
y=100;
xi=0;
yi=1;
a[0][1]=b;
status=1;
}
break;

case 2:
if(a[0][2]==0)
{
x=224;
y=100;
xi=0;
yi=2;
a[0][2]=b;
status=1;
} 
break;

case 3:
if(a[0][3]==0)
{
x=311;
y=100;
xi=0;
yi=3;
a[0][3]=b;
status=1;
}
break;

case 4:
if(a[1][0]==0)
{
x=50;
y=175;
xi=1;
yi=0;
a[1][0]=b;
status=1;
} 
break;

case 5:
if(a[1][1]==0)
{
x=137;
y=175;
xi=1;
yi=1;
a[1][1]=b;
status=1;
} 
break;

case 6:
if(a[1][2]==0)
{
x=224;
y=175;
xi=1;
yi=2;
a[1][2]=b;
status=1;
} 
break;

case 7:
if(a[1][3]==0)
{
x=311;
y=175;
xi=1;
yi=3;
a[1][3]=b;
status=1;
}
break;

case 8:
if(a[2][0]==0)
{
x=50;
y=250;
xi=2;
yi=0;
a[2][0]=b;
status=1;
}
break;

case 9:
if(a[2][1]==0)
{
x=137;
y=250;
xi=2;
yi=1;
a[2][1]=b;
status=1;
}
break;

case 10:
if(a[2][2]==0)
{
x=224;
y=250;
xi=yi=2;
a[2][2]=b;
status=1;

}
break;

case 11:
if(a[2][3]==0)
{
x=311;
y=250;
xi=2;
yi=3;
a[2][3]=b;
status=1;
}
break;

case 12:
if(a[3][0]==0)
{
x=50;
y=325;
xi=3;
yi=0;
a[3][0]=b;
status=1;
}
break;

case 13:
if(a[3][1]==0)
{
x=137;
y=325;
xi=3;
yi=1;
a[3][1]=b;
status=1;
}
break;

case 14:
if(a[3][2]==0)
{
x=224;
y=325;
xi=3;
yi=2;
a[3][2]=b;
status=1;
}
break;

case 15:
if(a[3][3]==0)
{
x=311;
y=325;
xi=yi=3;
a[3][3]=b;
status=1;
}
break;

} //end switch
}

public void keyPressed(KeyEvent e)
{
int i,j,k,flag=7;
int key=e.getKeyCode();
g=0;
switch(key)
{
case KeyEvent.VK_UP:
for(k=1;k<=3;k++)
{
 for(i=3;i>=1;i--)
 {
 for(j=0;j<=3;j++)
  {
  if(a[i][j]==0 || (a[i][j]!=a[i-1][j] && a[i-1][j]!=0) || j==flag)
  continue; 
  else
   {
    g=1;
    if(a[i-1][j]==0)
    {
     a[i-1][j]=a[i][j];
     lb[i-1][j].setText(Integer.toString(a[i-1][j]));
     lb[i-1][j].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f);
    } 
   else if(a[i][j]==a[i-1][j])
   {
    if(flag==7)
     flag=5;
    if(i>1 && a[i-2][j]==a[i][j])
    {
     a[i-2][j]=a[i-2][j]+a[i-1][j];
     a[i-1][j]=a[i][j];
     lb[i-2][j].setText(Integer.toString(a[i-2][j]));
     lb[i-2][j].setFont(f);
     lb[i-1][j].setText(Integer.toString(a[i-1][j]));
     lb[i-1][j].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     }
     else
     {
     a[i-1][j]=a[i][j]+a[i-1][j];
     lb[i-1][j].setText(Integer.toString(a[i-1][j]));
     lb[i-1][j].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f); 
     }
    }
      
   if(i>1)
     {
     if(a[i-1][j]==a[i-2][j] && flag==5)
     flag=j;
     }
    }
  }
 }
}
break;

case KeyEvent.VK_DOWN:
for(k=1;k<=3;k++)
{
 for(i=0;i<3;i++)
 {
 for(j=0;j<=3;j++)
  {
  if(a[i][j]==0 || (a[i][j]!=a[i+1][j] && a[i+1][j]!=0) || j==flag)
  continue; 
  else
   {
    g=1;
    if(a[i+1][j]==0)
    {
     a[i+1][j]=a[i][j];
     lb[i+1][j].setText(Integer.toString(a[i+1][j]));
     lb[i+1][j].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f);
    } 
   else if(a[i][j]==a[i+1][j])
   {
   if(flag==7)
     flag=5;
   if(i<2 && a[i+1][j]==a[i+2][j])
   {
     a[i+2][j]=a[i+2][j]+a[i+1][j];
     a[i+1][j]=a[i][j];
     lb[i+2][j].setText(Integer.toString(a[i+2][j]));
     lb[i+2][j].setFont(f);
     lb[i+1][j].setText(Integer.toString(a[i+1][j]));
     lb[i+1][j].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
   }
   else
   {
   a[i+1][j]=a[i][j]+a[i+1][j];
   lb[i+1][j].setText(Integer.toString(a[i+1][j]));
   lb[i+1][j].setFont(f);
   a[i][j]=0;
   lb[i][j].setText("");
   lb[i][j].setFont(f);
   }
  }
   if(i<2)
     {
     if(a[i+1][j]==a[i+2][j] && flag==5)
     flag=j;
     }
    }
  }
 }
}
break;

case KeyEvent.VK_RIGHT:
for(k=1;k<=3;k++)
{
 for(j=0;j<3;j++)
 {
 for(i=0;i<=3;i++)
  {
  if(a[i][j]==0 || (a[i][j]!=a[i][j+1] && a[i][j+1]!=0) || i==flag)
  continue; 
  else
   {
    g=1; //to control number generation when no move occurs
    if(a[i][j+1]==0) // to shift numbers right
    {
     a[i][j+1]=a[i][j];
     lb[i][j+1].setText(Integer.toString(a[i][j+1]));
     lb[i][j+1].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f);
    } 
   //if(i==flag) // i.e. if merging has occured once
   
   else if(a[i][j]==a[i][j+1]) // to merge
   {
   if(flag==7)
     flag=5;
   if(j<2 && a[i][j+1]==a[i][j+2])
   {
     a[i][j+2]=a[i][j+2]+a[i][j+1];
     a[i][j+1]=a[i][j];
     lb[i][j+2].setText(Integer.toString(a[i][j+2]));
     lb[i][j+2].setFont(f);
     lb[i][j+1].setText(Integer.toString(a[i][j+1]));
     lb[i][j+1].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
   }
   else
   {
   a[i][j+1]=a[i][j]+a[i][j+1];
   lb[i][j+1].setText(Integer.toString(a[i][j+1]));
   lb[i][j+1].setFont(f);
   a[i][j]=0;
   lb[i][j].setText("");
   lb[i][j].setFont(f);
   }
  }
   if(j<2)
     {
     if(a[i][j+1]==a[i][j+2] && flag==5)
     flag=i;
     }
    }
  }
 }
}
break;

case KeyEvent.VK_LEFT:
for(k=1;k<=3;k++)
{
 for(j=3;j>0;j--)
 {
 for(i=0;i<=3;i++)
  {
  if(a[i][j]==0 || (a[i][j]!=a[i][j-1] && a[i][j-1]!=0) || i==flag)
  continue; 
  else
   {
    g=1;
    if(a[i][j-1]==0)
    {
     a[i][j-1]=a[i][j];
     lb[i][j-1].setText(Integer.toString(a[i][j-1]));
     lb[i][j-1].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f);
    } 
   
   else if(a[i][j]==a[i][j-1])
   {
    if(flag==7)
     flag=5;
    if(j>1 && a[i][j-1]==a[i][j-2])
    {
     a[i][j-2]=a[i][j-2]+a[i][j-1];
     a[i][j-1]=a[i][j];
     lb[i][j-2].setText(Integer.toString(a[i][j-2]));
     lb[i][j-2].setFont(f);
     lb[i][j-1].setText(Integer.toString(a[i][j-1]));
     lb[i][j-1].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
    }
    else
    {
     a[i][j-1]=a[i][j]+a[i][j-1];
     lb[i][j-1].setText(Integer.toString(a[i][j-1]));
     lb[i][j-1].setFont(f);
     a[i][j]=0;
     lb[i][j].setText("");
     lb[i][j].setFont(f);
    }
   }
   if(j>1)
     {
     if(a[i][j-1]==a[i][j-2] && flag==5)
     flag=i;
     }
    }
  }
 }
}
break;
}
color();
four();
}

void color()
{
 for(int p=0;p<4;p++)
 {
  for(int q=0;q<4;q++)
  {
   if(a[p][q]<10)
   {
    lb[p][q].setBackground(Color.white);
    lb[p][q].setForeground(Color.black);
   }
   else if(a[p][q]<100)
   {
    lb[p][q].setBackground(Color.yellow);
    lb[p][q].setForeground(Color.red);
   }
   else if(a[p][q]<1000)
   {
    lb[p][q].setBackground(Color.cyan);
    lb[p][q].setForeground(Color.red);
   }
   else if(a[p][q]==1024)
   {
    lb[p][q].setBackground(Color.yellow);
    lb[p][q].setForeground(Color.blue);
   }
   else if(a[p][q]==2048)
   {
    lb[p][q].setBackground(Color.red);
    lb[p][q].setForeground(Color.white);
    JOptionPane.showMessageDialog(null,"You Won!\nTo Continue Playing,click OK","2048",JOptionPane.INFORMATION_MESSAGE);
   }
  }
 }
}
 
public void keyReleased(KeyEvent e)
{
}

public void keyTyped(KeyEvent e)
{
}

public void paint(Graphics g)
{
g.setColor(Color.green);
g.fillRect(50,100,350,300); // x=87 and y=75
g.setColor(Color.BLACK);
g.drawLine(137,100,137,400);
g.drawLine(224,100,224,400);
g.drawLine(311,100,311,400);

g.drawLine(50,175,400,175);
g.drawLine(50,250,400,250);
g.drawLine(50,325,400,325);
}
}
