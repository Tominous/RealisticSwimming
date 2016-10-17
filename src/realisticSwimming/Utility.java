/*
Copyright (c) 2016 4a2e532e

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package realisticSwimming;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import realisticSwimming.main.RSMain;

public class Utility {

    public static boolean playerHasPermission(Player p, String perm){
        if(!Config.permsReq){
            return true;
        }else if(p.hasPermission(perm)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean playerIsInCreativeMode(Player p){
        if(Config.enabledInCreative){
            return false;
        }else if(p.getGameMode()== GameMode.CREATIVE){
            return true;
        }else{
            return false;
        }
    }

    public static void ncpFix(Player p){
        p.addAttachment(RSMain.getMain(), "nocheatplus.checks", true, Config.noCheatPlusExemptionTimeInTicks);
    }

    public static boolean isInWaterElevator(Player p){

        //TODO make configurable
        int width = 3;

        if(p.getLocation().add(width, 0, 0).getBlock().getType() != Material.STATIONARY_WATER
                && p.getLocation().add(-width, 0, 0).getBlock().getType() != Material.STATIONARY_WATER
                && p.getLocation().add(0, 0, width).getBlock().getType() != Material.STATIONARY_WATER
                && p.getLocation().add(0, 0, -width).getBlock().getType() != Material.STATIONARY_WATER){
            return true;
        }else {
            return false;
        }
    }
}
