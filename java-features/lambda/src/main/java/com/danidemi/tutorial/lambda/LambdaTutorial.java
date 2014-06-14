package com.danidemi.tutorial.lambda;

/**
 *
 * @author danidemi
 */
public class LambdaTutorial {
    
    static interface Sound {
        String play();
    }
    
    static class Player {
        public void play(Sound sound){
            System.out.println( sound.play() );
        }
    }

    private void run() {
                
        Player player = new Player();
        
        player.play( new Sound(){
            
            @Override
            public String play() {
                return "Boooom";
            }
            
        });
        
        
        player.play( ()->{return "Crash";} );
        
    }

    public static void main(String[] args) {
        new LambdaTutorial().run();
    }
    
}
