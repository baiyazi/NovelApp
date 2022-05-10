package com.mengfou.netwrok

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mengfou.entity.NovelDetail
import com.mengfou.viewmodels.HomeFragmentViewModel

/**
 * @author 梦否 on 2022/5/9
 * @blog https://mengfou.blog.csdn.net/
 */
class NetwrokRequestClient : AppNetwrokAPI {
    override fun doRequestNovelDetailFirstPage(novelType: HomeFragmentViewModel.NovelType): LiveData<List<NovelDetail>>? {
        return doRequestNovelDetailByNovelTypeAndPageNumber(novelType, 1)
    }

    override fun doRequestNovelDetailByPageNumber(novelType: HomeFragmentViewModel.NovelType, pageNumber: Int): LiveData<List<NovelDetail>>? {
        return doRequestNovelDetailByNovelTypeAndPageNumber(novelType, pageNumber)
    }

    override fun doRequestNovelDetailById(id: String): NovelDetail {
        // todo 模拟一条数据
        val limit = 5
        val pageNumber = 1
        val it = 0
        return NovelDetail(
            "132 ${(pageNumber- 1) * limit + it}", it, "catName ${(pageNumber- 1) * limit + it}", "picUrl  ${(pageNumber- 1) * limit + it}",
            "bookName ${(pageNumber- 1) * limit + it}", "authorName ${(pageNumber- 1) * limit + it}", "bookDesc ${(pageNumber- 1) * limit + it}", "score ${(pageNumber- 1) * limit + it}",
            "wordCount ${(pageNumber- 1) * limit + it}", "", "", ""
        )
    }

    override fun doRequestNovelSectionPageByNovelIdAndSectionId(novelId: String?, sectionId: Int): String {
        // todo 模拟查询一条章节数据
        return "<div id=\"showReading\" class=\"readBox\" style=\"font-size: 16px; font-family: microsoft yahei\">　　李叱回到大宅的时候天色已经渐暗，一天便这样飞快过去。<br><br>　　他在门口下车，作为名义上的安阳分号大掌柜，余九龄也跟他一起去了。<br><br>　　两个人下车后，才注意到沈如盏擎着油纸伞在门口等他。<br><br>　　李叱慌，李叱慌，李叱慌完余九龄慌。<br><br>　　虽然余九龄不知道自己为什么慌，可是真的慌。<br><br>　　李叱刚要紧走几步，沈如盏压低声音说道：“走慢些，指不定多少人暗中看着呢。”<br><br>　　李叱脚步调整了一下，装作自然而然的走到沈如盏身边，两个人共用一把伞回到院子里。<br><br>　　余九龄看着他们两个进去，抬头看着天空，天是灰蒙蒙的，小雨是淅沥沥的。<br><br>　　他们在河边钓鱼之后，下午去了曹家的兴盛德分号参观，出门的时候才发现阴天了，走到半路下起了小雨。<br><br>　　跟在那两人身后，淋着小雨的余九龄却有一种错觉。<br><br>　　他感觉自己是个太阳，正在那两个人身边发光发热。<br><br>　　回到客厅，李叱等余九龄进门后楞了一下，余九龄也在幽怨的看着他。<br><br>　　李叱叹道：“看来还是有疏忽的地方，交代弟兄们，明面上要对九妹尊敬些，他是分号的大掌柜。”<br><br>　　余九龄心说当家的还算你有良心。<br><br>　　李叱说完后对沈如盏说道：“我们今天去看了曹家的兴盛德。”<br><br>　　沈如盏一边倒茶一边问：“怎么样？”<br><br>　　李叱回答：“远不如你的沈医堂，大概就差了十个十万八千里。”<br><br>　　沈如盏嘴角微微一扬。<br><br>　　她递给李叱一杯热茶后问道：“觉得哪里不如沈医堂。”<br><br>　　李叱道：“处处不如，兴盛德就是要赚钱的，没有医者气。”<br><br>　　沈医堂不一样，沈医堂虽然也赚钱，而且在药行这个生意里，再没有一家比得上沈医堂能赚钱，可是沈医堂里最浓的是医者的气息。<br><br>　　坐馆的郎中不会因为来的人没钱，就不给患者仔细诊治。<br><br>　　事实上，沈医堂从富户商人和达官贵人手里赚来的银子，有一部分就补贴在了穷苦百姓们身上。<br><br>　　而兴盛德不一样，有钱就看病，没钱请离开。<br><br>　　兴盛德药行的前厅里挂着两块竖匾，左边的是免开尊口，右边的是概不赊账。<br><br>　　沈医堂的前厅里也有两块竖匾，左边的是药本毒物，右边的是救人为尚。<br><br>　　李叱坐下来后说道：“将来我若有能力，就在各地办医馆，按照你的沈医堂标准办。”<br><br>　　他看似随口一说，可是沈如盏却仔细想了一下。<br><br>　　一个朝廷，如果给百姓们在各地都办了官方的医馆，这确实是一件大实事。<br><br>　　沈如盏想到这之后笑了笑道：“那等你办这件事的时候，沈医堂可怎么办？”<br><br>　　李叱怔住，连忙解释道：“我也只是随便说说。”<br><br>　　忽然间有一句话从沈如盏脑海里冒出来，但她没能说出口。<br><br>　　这句话是......君无戏言。<br><br>　　她觉得自己此时若说出这四个字，可能会把那妖孽吓老大一跳。<br><br>　　“你今天一天不在。”<br><br>　　沈如盏道：“但是客人比你预料的来的早，今天下午的时候，府治刘大人的夫人来过了。”<br><br>　　李叱想到了，却没有想到会这么快。<br><br>　　不过再想想，刘尧可是着急分钱的，他现在盼着沈医堂赚钱的心情，可比李叱自己还要迫切。<br><br>　　刘大人亲自出马，刘夫人也亲自出马。<br><br>　　这事，这夫妻二人如此卖力，想不成都难了。<br><br>　　理论上，驻军不管地方事务，所以在安阳城里，刘尧也是理论上的最高官员。<br><br>　　他先做了表率，后边的人就会蜂拥而至。<br><br>　　见李叱没有说话，沈如盏知道李叱是在想解决的办法。<br><br>　　府治大人的夫人先来拜访了，后边的人络绎不绝，李叱在想的是若烦了沈如盏也不好。<br><br>　　“我若不想应付，自会对你说。”<br><br>　　沈如盏语气平和的说道：“我没说的时候，你也不用去想。”<br><br>　　李叱下意识的点了点头，然后才注意到，沈如盏轻笑的样子，确实很美。<br><br>　　然而两个人这四目相对，却并无深情款款。<br><br>　　沈如盏甚至在李叱看她的眼神里，隐隐约约的看到这个孽畜正在想......此女子也不知道愿不愿意做我嫂子。<br><br>　　所以沈如盏若有深意的看了李叱一眼，转身走了。<br><br>　　她没有瞪人，可是李叱却觉得自己被骂了一样，还是被劈头盖脸骂了一顿的那种。<br><br>　　七天后，沈医堂安阳分号比预料的提前了七八天开业，速度之快超乎想象。<br><br>　　官府这边的事一路畅通无阻，工匠这边昼夜轮休，所以时间提前了一半还多。<br><br>　　这一天，为了给沈医堂造势，安阳城府治大人刘尧亲自到场祝贺。<br><br>　　本来那些地方官员还在犹豫要不要来，毕竟他们的身份特殊，亲自到场显得有些过分。<br><br>　　然而刘大人都去了，他们还能坐得住？<br><br>　　于是沈医堂门外，车水马龙。<br><br>　　刘大人才到不久，小侯爷曹猎也到了，然后是作为孟可狄代表的丁胜甲也到了。<br><br>　　一时之间，地方官府和军方的人都到了。<br><br>　　这场面就显得有些隆重，也再一次让人看到了沈医堂的不一样。<br><br>　　说实话，外来的商人要在本地立足谈何容易，不说其他，单说药行，只一个兴盛德就能把所有外来的商人全都压住。<br><br>　　想在有兴盛德的地方做药行生意，只有两个选择，要么听话要么滚蛋。<br><br>　　这一天的热闹隆重，连百姓们都看出来了沈医堂大有来头，那本原本蠢蠢欲动想趁乱干点什么的小毛贼，硬是没敢动手。<br><br>　　又十天后，李叱购买的三艘新船到了，这三艘船是从曹家的船队里来买的。<br><br>　　按照曹猎的想法，自然是送给李叱也没什么，对他来说，三艘船如毛毛雨一样。<br><br>　　可是李叱对他却坚持亲兄弟明算账，钱款如数交付。<br><br>　　三艘船这一到，还是从曹家的船队里买来的，这一下，南平江上做生意的人也隐隐约约嗅到了一股不寻常的味道。<br><br>　　将军府。<br><br>　　孟可狄一边品茶，一边听着刘尧等人的汇报，越听越觉得有意思。<br><br>　　刘尧笑了笑说道：“这个李公子，做事确实很务实，丝毫也不虚托。”<br><br>　　孟可狄点了点头：“务实就好，不务实说明心里有鬼，他越是务实，在安阳的投入越大，这个人就越是可信。”<br><br>　　丁胜甲道：“属下这边得到的消息也很好，沈医堂各地的分号，已经把所在州县的布防都查出来。”<br><br>　　他看向孟可狄说道：“距离近的州县，沈医堂的人已经把这些东西全都送到了，距离远一些的也在路上。”<br><br>　　孟可狄笑起来：“这么看，确实是个务实的人。”<br><br>　　刘尧道：“他本来说要在两个月后买船，结果这才二十天不足，已经有三艘新船到了。”<br><br>　　“下官还派人去船坞那边问了问，船坞那边的人说，李公子在他们那定了十艘货船，有一艘正在建造。”<br><br>　　孟可狄思考了一下，十艘大船，最少两年才能建完，看来李怼怼是真的要在安阳定居下来。<br><br>　　孟可狄道：“其实他做什么生意我不管。”<br><br>　　稍一停顿，孟可狄继续说道：“我要的只是冀州各地的布防情况，夏粮种植的分布，最好是我攻城的时候可以里应外合。”<br><br>　　他看向丁胜甲：“你现在来看，沈医堂能做到吗？”<br><br>　　丁胜甲回答道：“里应外合的事不敢确定，但前面两件事，沈医堂做的还不错。”<br><br>　　孟可狄道：“你和李怼怼走的比较亲近，明日你再去问问，若他能答应做到，我们实在不能拖着了。”<br><br>　　丁胜甲俯身道：“将军放心，属下明日就去问。”<br><br>　　孟可狄又看向薛纯豹道：“你为先锋，我给你一军兵马，早就让你准备，你准备的如何了？”<br><br>　　薛纯豹俯身：“回将军，先锋军已经准备妥当，随时都可开拔。”<br><br>　　“那就后天吧。”<br><br>　　孟可狄道：“后天是五月十九，我找人算过，是个好日子。”<br><br>　　薛纯豹立刻就兴奋起来，他这样嗜杀好战之人，一听说马上就要打仗了，那股兴奋劲儿压都压不住。<br><br>　　他大声应了：“是！”<br><br>　　孟可狄继续说道：“这次出兵，薛纯豹带一军兵马为先锋，我自带五万人马为中军，丁胜甲带一军兵马为后队。”<br><br>　　他起身，走到地图前看了一会儿后，抬起手指了指冀州位置：“先锋军后天出城，大军在三天后开拔，六月中务必到冀州城外。”<br><br>　　“是！”<br><br>　　所有人整齐的应了一声。<br><br>　　与此同时，沈医堂。<br><br>　　书房里，余九龄有些心急的看向李叱。<br><br>　　“当家的，你和我大哥定亲的日子，只剩下二十天了，你到底打算什么时候走？”<br><br>　　李叱笑了笑道：“如不出意外，孟可狄的队伍再有三四天就要出征，他前脚走，我后脚就走。”<br><br>　　余九龄道：“咱们来的时候可是走了将近一个月的时间，你就算三四天后出发，只剩下半个月的时间了，还能不能来得及？”<br><br>　　李叱道：“真是难得的好兄弟，你大哥整天拿土坷垃砸你，你却依然这么为她着想。”<br><br>　　余九龄道：“她要是不拿土坷垃砸我，我还不提她操心呢。”<br><br>　　李叱笑了起来，走到窗口，看着前边大堂里的人头攒动。<br><br>　　“半个月的时间足够了。”<br><br>　　李叱深深吸了口气：“我答应她的，就不会食言。”<br><br>　　坐在不远处的沈如盏看着这个家伙的背影，想着懂得信守诺言的人，果然比较顺眼。<br><br>　　曾经她也有过一个许诺，可是她没来得及赴约。<br><br>　　她知道的时候，是在她和他约定之期过后的第九天，他战死疆场。<br><br>　　他是那般优秀的一个人，若是白天，他便是阳光，若是夜晚，他便是星辰。<br><br>　　她因为救人而耽误了赴约，等到她赶到凉州的时候，他已经不在人世。<br><br>　　于是她在凉州留了下来，从没有这样在一个地方停留了这么久。<br><br>　　三年。<br><br>　　三年守灵。<br><br>　　所以才有了第一家沈医堂，就在凉州。<br><br>　　他是重伤不治而死，她便留在凉州救了更多的人，她知道，救多少人也救不回他。<br><br>　　他的坟就在城外，她经常去。<br><br>　　可是......<br><br>　　一望可相见，一步如重城。<br><br>　　</div>\n" +
                "\n" +
                "                        \n"
    }

    // 模拟
    private fun doRequestNovelDetailByNovelTypeAndPageNumber(novelType: HomeFragmentViewModel.NovelType, pageNumber: Int) : LiveData<List<NovelDetail>>? {
        val limit = 5
        val result_list: MutableLiveData<List<NovelDetail>> = MutableLiveData()
        val temp_list = mutableListOf<NovelDetail>()
        repeat(limit) {
            temp_list.add(
                NovelDetail(
                    "132 ${(pageNumber- 1) * limit + it}", it, "catName ${(pageNumber- 1) * limit + it}", "picUrl  ${(pageNumber- 1) * limit + it}",
                    "bookName ${(pageNumber- 1) * limit + it}", "authorName ${(pageNumber- 1) * limit + it}", "bookDesc ${(pageNumber- 1) * limit + it}", "score ${(pageNumber- 1) * limit + it}",
                    "wordCount ${(pageNumber- 1) * limit + it}", "", "", ""
                )
            )
        }
        result_list.value = temp_list
        return result_list
    }
}