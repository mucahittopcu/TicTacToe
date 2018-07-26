package tictactoe;

class OyunTahtasi
{
    int n;
    char [][] oyunTahta=new char[n][n];
    
    public OyunTahtasi()
    {
        
    }
    public OyunTahtasi(char [][] oynTahtasi)
    {
        this.oyunTahta=oynTahtasi;
    } 
    
    char [][] oyunTahtasiniAl()
    {
        return oyunTahta;
    }
    
    void oyunTahtasiniYazdir()
    {
        for(int i=0;i<oyunTahta.length;i++)
        {
            for(int j=0;j<oyunTahta.length;j++)
            {
                System.out.print(" "+oyunTahta[i][j]+" ");
            }
            System.out.println();
        }
    }
    boolean hamleyiYaz(String koordinat, char oyuncu)
    {
        
        int myInt = Integer.parseInt(koordinat);
        int x = myInt/10;
        int y= myInt%10;
        if(x>=(oyunTahta.length) || y>=(oyunTahta.length)){
            return false; 
        }
        if(oyunTahta[x][y]!='-')
        {
            return false; 
        }
        else
        {
            oyunTahta[x][y]=oyuncu;
            return true;
        }
    }
    boolean kazanan(char oyuncu)
    {
        if(oyunTahta.length-1==3)
        {
            //sağ ve sol kontrol
            for(int i=1;i<oyunTahta.length;i++)
            {
                for(int j=1;j<oyunTahta.length-2;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i][j+1]==oyuncu && oyunTahta[i][j+2]==oyuncu)
                    {
                        return true;
                    }
                    
                }
            }
            //yukarı ve aşağı kontrol
            for(int j=1;j<oyunTahta.length;j++)
            {
                for(int i=1;i<oyunTahta.length-2;i++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i+1][j]==oyuncu && oyunTahta[i+2][j]==oyuncu)
                    {
                        return true;
                    }
                
                }
            }
            //capraz kontrol
            for(int i=1;i<oyunTahta.length-2;i++)
            {
                for(int j=1;j<oyunTahta.length-2;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i+1][j+1]==oyuncu && oyunTahta[i+2][j+2]==oyuncu)
                    {
                        return true;
                    }
                }
            }
            //sol capraz kontrol
            for(int i=3;i<oyunTahta.length;i++)
            {
                for(int j=1;j<oyunTahta.length-2;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i-1][j+1]==oyuncu && oyunTahta[i-2][j+2]==oyuncu)
                    {
                        return true;
                    }   
                }
            }
        }
        else if((oyunTahta.length-1)==5 || (oyunTahta.length-1)==7)
        {  
            //sağ ve sol kontrol
            for(int i=1;i<oyunTahta.length;i++)
            {
                for(int j=1;j<oyunTahta.length-3;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i][j+1]==oyuncu && oyunTahta[i][j+2]==oyuncu && oyunTahta[i][j+3]==oyuncu)
                    {
                        return true;
                    } 
                }
            }
            //yukarı ve aşağı kontrol
            for(int j=1;j<oyunTahta.length;j++)
            {
                for(int i=1;i<oyunTahta.length-3;i++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i+1][j]==oyuncu && oyunTahta[i+2][j]==oyuncu && oyunTahta[i+3][j]==oyuncu)
                    {
                        return true;
                    }
                
                }
            }
            //capraz kontrol
            for(int i=1;i<oyunTahta.length-3;i++)
            {
                for(int j=1;j<oyunTahta.length-3;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i+1][j+1]==oyuncu && oyunTahta[i+2][j+2]==oyuncu && oyunTahta[i+3][j+3]==oyuncu)
                    {
                        return true;
                    }
                    
                }
            }
            //sağa capraz kontrol
            for(int i=4;i<oyunTahta.length;i++)
            {
                for(int j=1;j<oyunTahta.length-3;j++)
                {
                    if(oyunTahta[i][j]==oyuncu && oyunTahta[i-1][j+1]==oyuncu && oyunTahta[i-2][j+2]==oyuncu && oyunTahta[i-3][j+3]==oyuncu)
                    {
                        return true;
                    }  
                }
            }
        
        }
        return false;
    }
    boolean berabere()
    {
        //Oyun tahtasında heryer dolu mu diye bakılır
        for(int i=1;i<oyunTahta.length;i++)
        {
            for(int j=1;j<oyunTahta.length;j++)
            {
                if(oyunTahta[i][j]=='X' || oyunTahta[i][j]=='O')
                {
                    continue;
                }
                else
                {
                    return false;
                }         
            }
        }
        return true;
    } 
}
