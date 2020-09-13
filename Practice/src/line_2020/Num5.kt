package line_2020

class Num5 {
    fun solution(cards: IntArray): Int {
        var dealer = intArrayOf()
        var dealerA = false
        var player = intArrayOf()
        var playerA = false
        var stop = false
        var seen = 0
        var idx = 0
        var money = 0
        for ( card in cards) {
            println("card $card")
            if (stop) {
                // dealer
                if (dealer.sum() >= 17) {
                    money+=checkWinner(player,dealer,playerA,dealerA)
                    println(money)
                    playerA=false
                    dealerA=false
                    player = intArrayOf()
                    dealer = intArrayOf()
                    idx=0
                    continue
                }
                idx++
                if (card > 10) {
                    dealer + 10
                } else {
                    dealer += card
                    if (card == 1)
                        dealerA = true
                }
            } else {
                if (idx % 2 == 0) {
                    // player
//                    println(card)
//                    println("$playerA ${player.sum()}")
                    if(playerA){
                        if (player.sum()+10 == 21) {
                            money+=checkWinner(player,dealer,playerA,dealerA)
                            println(money)
                            playerA=false
                            dealerA=false
                            player = intArrayOf()
                            dealer = intArrayOf()
                            idx=0
                            continue
                        }
                    }
                    if (player.sum() == 21) {
                        money+=checkWinner(player,dealer,playerA,dealerA)
                        println(money)
                        playerA=false
                        dealerA=false
                        player = intArrayOf()
                        dealer = intArrayOf()
                        idx=0
                        continue
                    }

                    if (idx > 3) {
                        if (seen == 1 || seen >= 7) {
                            if (player.sum() >= 17) {
                                money+=checkWinner(player,dealer,playerA,dealerA)
                                println(money)
                                playerA=false
                                dealerA=false
                                player = intArrayOf()
                                dealer = intArrayOf()
                                idx=0
                                continue
                            }
                        }
                        if (seen == 4 || seen == 5 || seen == 6) {
                            stop = true
                            money+=checkWinner(player,dealer,playerA,dealerA)
                            println(money)
                            playerA=false
                            dealerA=false
                            player = intArrayOf()
                            dealer = intArrayOf()
                            idx=0
                            continue
                        }
                        if (seen == 2 || seen >= 3) {
                            if (player.sum() >= 12) {
                                money+=checkWinner(player,dealer,playerA,dealerA)
                                println(money)
                                playerA=false
                                dealerA=false
                                player = intArrayOf()
                                dealer = intArrayOf()
                                idx=0
                                continue
                            }
                        }
                    }
                    idx++
                    if (card > 10) {
                        dealer + 10
                    } else {
                        player += card
                        if (card == 1) {
                            playerA = true
                        }
                    }
                    if (player.sum() > 21) {
                        money+=checkWinner(player,dealer,playerA,dealerA)
                        println(money)
                        playerA=false
                        dealerA=false
                        player = intArrayOf()
                        dealer = intArrayOf()
                        idx=0
                        continue
                    }
                } else {
                    // dealer
                    idx++
                    if (card > 10) {
                        dealer + 10
                    } else {
                        dealer += card
                        if (card == 1) {
                            dealerA = true
                        }
                    }
                    if (idx == 3)
                        seen = card
                }
            }
        }
        if(player.size>0||dealer.size>0){
            money+=checkWinner(player,dealer, playerA, dealerA)
        }
        return money

    }
    fun checkWinner(player:IntArray, dealer:IntArray, playerA:Boolean, dealerA:Boolean):Int{
        val playerSum = player.sum()
        val dealerSum = dealer.sum()
        println("$playerSum:$dealerSum")

        if(dealerSum>21){
            if(playerA) {
                if (playerSum == 21 || playerSum + 10 == 21){
                    return 3
                }
                if(playerSum>21){
                    return 0
                }
                return 2
            }
            if (playerSum == 21){
                return 3
            }
            if(playerSum>21){
                return 0
            }
            return 2
        }
        if(playerSum>21){
            if(dealerA){
                if(dealerSum == 21|| dealerSum+10==21){
                    return -2
                }
                if(dealerSum>21){
                    return 0
                }
                return -1
            }
            if(dealerSum == 21){
                return -2
            }
            if(dealerSum>21){
                return 0
            }
            return -1
        }
        if (dealerSum < playerSum) {
            if(playerA){
                if(playerSum == 21||playerSum+10==21)
                    return 3
            }
            if(playerSum == 21)
                return 3
            return 2
        } else if (dealerSum == playerSum) {
            return 0
        }else{
            if(playerA){
                if(playerSum == 21||playerSum+10==21)
                    return 3
            }
            if(dealerSum == 21)
                return -2
            return -1
        }
    }
}