package com.codenjoy.dojo.kata.model.algorithms;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2023 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.services.questionanswer.levels.AlgorithmLevelImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DuplicateRemoveAlgorithm extends AlgorithmLevelImpl {

    @Override
    public String get(String input) {
        Stack<String> stack = new Stack<>();
        String deleted = "";
        for (String c : input.split("")) {
            if (stack.isEmpty() && !c.equals(deleted)) {
                stack.push(c);
                deleted = "";
            } else if (deleted.equals(c)) {
                //skip
            } else if (stack.peek().equals(c)) {
                deleted = stack.pop();
            } else {
                stack.push(c);
                deleted = "";
            }
        }
        return String.join("", stack);
    }

    @Override
    public String winCode() {
        return "function program(input) {\n" +
                "const stack = [];\n" +
                "let deleted = \"\";\n" +
                "\n" +
                "for (let i = 0; i < input.length; i++) {\n" +
                "    const c = input.charAt(i);\n" +
                "\n" +
                "    if (stack.length === 0 && !c===deleted) {\n" +
                "        stack.push(c);\n" +
                "        deleted = \"\";\n" +
                "    } else if (deleted === c) {\n" +
                "        //skip\n" +
                "    } else if (stack[stack.length - 1] === c) {\n" +
                "        deleted = stack.pop();\n" +
                "    } else {\n" +
                "        stack.push(c);\n" +
                "        deleted = \"\";\n" +
                "    }\n" +
                "}\n" +
                "return stack.join(\"\");\n" +
                "}";
    }

    @Override
    public List<String> description() {
        return Arrays.asList("Remove all adjacent duplicate characters from a string, " +
                "as soon as you encounter them walking left to right, " +
                "and ensuring that at the end NO two adjacent characters remain.\n" +
                "Example: abc=>abc\n" +
                "abbc=>ac\n" +
                "abbbc=>ac\n" +
                "abbcccbad=>abad"
        );
    }

    @Override
    public List<String> getQuestions() {
        return List.of("a",
                "abc",
                "abcba",
                "aa",
                "aaaa",
                "aaabaa",
                "aabaaa",
                "abaa",
                "abba",
                "abbaaa",
                "abcdeedcba",
                "bcdeeedcbabcde",
                "fffkkhhffzzhhkkkzzrrrrryyy",
                "beellllgrhhoyy",
                "abbcccbad",
                "abccbbad",
                "abcdeffedcbar",
                "abcdeffedcba",
                "abcdefaaabbbvvvfedcba",
                "ddllppppccffmmkkkkjjggggffvvvuaaoooxtttnyyrffbbbbiqqddddigggsssmpjjjxxnnhhhiiccssxjjjkkkooooommmaaaacccrrraafuuuuaannnngqqzzzwwrrrkkfffssssmaajtttxxvlllwwwwffffhhhhaccccggeekkgggbbwkkkkjjjjdmmmvhhhhtttzzuuuffppppovvttiiiibbbrrrrbbbyyyttttrreeeerwwwhhbwwwwvbbppppssiiiiszzqqqmmmmrllmmmmrrrkkkkkdhhdddduciiiibvsssqqqkeeuuuupcccsscccpppzcccbbbcccchhkkkkdaiiiizzzllleeeeooooapppduuxxjvvvqqqqrnnnbhppppjjjfeessssvvvaaaahhffhhhhhhkkkmmpiooooqqmmmmzzzzszzzzggfhhggbbbhhhccnnnnpxvvvvfffpjbnuuuuzzzzidzzllxxxxddddiiibbbjjrrmrnnnniiwbeeoootdddtttujgghhhhpsddoooohhhhsuuuiikvvvnnnyywwooyyyxxxppgqkkqfffxxpvvveeeetnnnnhhhxxxxbbyyyyyccaapabbbbllmjjrraggccccceeqqqqxxxcckkkiissssoiiikkccccssszzzzkkkkmmmvvvbttjjjjjppsuuuwwuuunnzzzzjjjnjjnnnuuuuccciiiwwiiiixxxxffffaaaassstttteejkpppqqqqeehhhwwkkkkppbbbbbttmrrrqttttttzzzrwwwwxxvvvvzzzvvrrrrzvvvvxsssqcvvvrrrrtggggzzzzvvhhhrrrwwwwgggwwwttthhhjjjjbbbjjbqqiwwwsssszzzzaaaakcccctttthhhfrzzzzqqccffnnnnnnnqqqqoolllfhhhhoooppppblspppptttbbbbxjjiiigggahhhhmmmeetttloddllljsssqffvvvvssoooeeeebiiiiiaaaallrrrrvjjjrtssssnrddsssbbbbyyynyaaaeeeetdddmmmmlffffllllppfffqqxxxxcccssszzkkknnaaaakkkksssvbbbqqlllggkkdddaallluuwwwvvvvghkkkkkkcxxnnnncjsssskyyyrrrrgggxxwwwwgggryyvvvviiiiiinnnccccjjjpptiiinccltyyyhzzzqaacyooppbbyyxxggggggddtzzzqqqssssfssxxxxqggxxxxkuuuwzzzccccgggllllxxxhuuurrvzjjjjooooccppmmwwwooyaaaffffttqqmuuuooiiggniwwwwxxxxxxxggggzzzllvvvvkkkgggvvshhusssdddqqqqeeeeddddxqqqqcccbddsssddddaaaayyyxxxkkkssssuuummmgggffhhhhcqqvvvvaarkkkksiiittqqqqjjjlllfkawxeeehhhhzuuuudddggggwwkkzffffaawwwffqttuuuuooooeeaadddnuuuulhhnnndwwwwyyykkgweenggggtttaawhkeeffddyyyyqjjjjleeeeppppuuugggbbbbrrmovvvxxxyyzjjggvvffffbbbssbrrrrgrrryyyorrfffrroorrrplsbxxffffnccccqqvvvgggghhddgffaaxxxhhhhrrrzzyyiihccccpppnnnfffkkiirrixxxzzzzhhhhzzzzkkkkwwwwwlllooollllkkkkikkgggjjjoooqqqqmmmuuuuggghhkkksssssssszzzzzzzzhhhhiiyyycccqssssllllggggkkkkxxxiiwwjjjpppzttyyymmmcccczzzzdddjjjjnnkkkbbvvjuwwwwiillavvuqqkkgjjjiiddddbnnuuttlnnllljjjjncccssqqquuuumbbbbggkknnnnnnngkkknnnyyddddkkkklsssmmmxxxacccjjjjgggeeehhzzzwfdzzzzppppcchtkkkppppvvvtuzzzkkvvvvvvvvnnnfffttnnnnyyyydddvvqckkzmmmpvvpooooxttaaaannrrtcjaaaaaaaujjjggggxxxwhhhggooossssdddkkkfggggnnnhhhoooohhtttwwwllxxxxppuuutttiiiiyyyyyyyynnnlffffhhhhmmm",
                "tnnnnnnnddddccccccckcmkkvvvbbbqqqqddannnnmbbbbssswwwwmmnnooieeesssqewwwwuuueggeeeeeeeuuddvvvvvvviiwwwwdjjjddeeebooooxxxjjjssszzzvvvvppuuuuttijrrriiiuuuxxxssssssuuujjjjrrrssssggggiiwwxxxggghhiiiikfuuupxxxxhvvvvjjppjjjjvvvwwwllomppccooooehbbbbhddaatrfccccfffeeelllleuuuurrmrhhhjjjuwzzdddduuuuqqqmmmggggzzzzsssjeeeehhaaoofffelllommattttrrrlllxxzzzzkkkkrrrrttwiiiuccxxxuooffnneeennniiiirrrffttllllbbbjjwwnnqqqwwwwujjjhhkxppoooggsssdxmmmmwwwwaazzznnnnhhhhhaqquuughhhhzzzzzzzlllllkhwwwppjxxjjssrrryhhhhssxxxxnnnkrrsrvvvllvvvvxxsssskwwwgyyjflllleannnggwjjccccjjjcppppddyppssssaaaappallqqqiqqiijjaaaabbbxxxtthhhhrrrrrgggffffllllhhnnnffffzzznnnnftttjjxxxvlllrrnnuuuggkkkkhooffwaaccccbxxxxoiiiifbbyjoommmmkkkssselllrrrrbbbyyytttthheooooqqqoooozzdddddduuaqqqmmmmiiippjjjbbccvvxxxxlllnnppppxxxxnneeeaaiitttiiiirrpffgttttlllrrrryyyyccccqqnnnnyyyyddddddffffjjjmiiiiyymllllrrrrzvccccrrrrqqrrrrygzzzzvvvvkkkrllzzmmmmktwyyvcggbbbdyyyykkkhhhuzzyyyyeeeeiiiiiiiylttttgggeeeeeyyyyaawyyyynnttttnzzddddoooovvvrusssshhhhhhhjjjjbbuuummmpppeeebcqqsssswwwaaaahhhpppnnrrrrggggreellssaassyytttqqnmmlggghsssyykfqqqqjjjaaaiieekcxxxxhbbffffpjvvwfzzzyssjjjjfffcqvvccfyyyoooooocclllxxxxddduuuuuhhccccwvvvsggllllvlqqtzzzzxxzzzzrrreeeevvvvjnnxxxxxowwwwxkkkkppppuuwddeyyyqqkkkkoaaaoobbbqqytptttohhhhxffffiicccuuuufffgggyyyysshhhqqjjvvttttffffaaarrrqggggyyyzzvppqqqqigbbbjjjqiiwwwwlllooozzzssssuutkklwwddrpppxxvvgggzaaakkkvvaqqqqnvvvyzjjjxbbwwwwssnnpyyeeeemmmlggjttttpppvmmmqqqqoccceetssssppphpwwkkkggemmmmaacyyqqqqusssnnbbyyyybbuuuhhhhssssjjaaeeeieeeeeeemmmwwtttjuffffssooojjssssiiiinnppppddddvwweefppppghhhhmmmhuuuunneeeeecccoonhhuuuuajjjjppptttttiidsmmmmcccqqqteeeerrrrbbhhhhrpddddppppmmxwwwkboorrtttvvyyyyffehhhhooftttrssovveeeeaaaffqqggyyyyccccgggccccvvvaaaaaaqjjjxxxxvvvvzvvvvddlllpssurreeeemmmunyyyyjhhhhqqqjjzzzziiiifffuuuggkkkkoeeiiiifaaajyyykvvvhhhhvvwwwkkqqopooooyyyfffeefffvpppaassskggiiqqqqquuuucxxxxbbtddddpppzzzzcceennhzzyyyuuuzzzjjjjfffxxxwqrrwwwwxxxfffffbbvveeaakffffrrrryyyyvvvvrrrrxooofffhvvvvccrrqqeeerddffnnwxxxxkkcccyyyycccbbbbqqqaeeeoooojiiddddeeeyyyykuttttuuuuwwllllaakkwwwvvvvmmmmmmuuubbllkaaaaklllljjjjzzzrkkkkwwwwoooddcccckkkwwwqqllllpppfffflccccnnhzzwwwwyyyooocckkkkppppuuuussswwwkkkrrrrxxxxbbbbbbbvvaaarrddvvvvvvnnnnxxaqqqqfffuuukkksssmmmmxpettbbbzzzkkkuuuuccppppfffkkcccdddrruuummngggqqqqjjjjyyyykkkkkkrrrkkkkfffftttyyzzuusssxrrrssbbhhhhhhgghbbbbzzzzyyiiilmmmiiiiitozzziiiiiypppuuaassttnnniizzzzqqibbbaaooooqqttkkkkuuuuvvvvpsssyyyyggkkkkrrlllllkkkkkiiiipppxgrrrrttdddnnnngwwwtffp",
                "paoooovvviiggggyyyynnnnhhhrjxbbbbbbfjjjjyaaaddqqbbbccueebbbbbbgwoiiyyxssccclyycmmmmhhfbooeeeeyxxxxxxxhmmmmpppplhhhhccccbbllllfffcccrrrremtpjmuuuuqqyguudppppqqeegskkksssyyyyideeeeeeeppgggueeeenneeeiiiddttttpppplllllhhrrreeeefffeeeeppppjjhhhttpppffbbjhhhhbbjjjjttttyyyyllliiiommmnnnwwwsshxxxxwaaaavjmmmmqqqqmmmmqqgggqzztuxxxrraaallddaaaaffffzzzzallliiiidddkxxxqqqffxhhhbbboiqqqqckeegiiidddccfftttvvvwwppzzzznnxxxlrrrrxjjjkkkkssssyytxxxccccssskkkkkkzzzznnnbbbssssxxttteeeeraahhhyyffffcccctdfvvttvvvrrrrxlllkkkkmmmooyyyeeeeddmmmmppppvvvvggggssswwwwxxxxhhtttttttttqhhknnffijjjssssdhwwwwjjjjccccllllaeiinnnnffxxxxmmmmrppppnnncciyrrrreeedeeeeccciiinnvvkgggqqqoooommaaaiiirbmmsskkqqqqzzzmmnnnnvvddddzzzzeeeessssqqqttxxddddiiqdkkmmmaanggghhhhkkoooobbnnnnjjjjttttkkkkooopssssllllxxxxlllzwwhhlzjjjbbxddzzwwwyggommmmfffqqqluuuuwwwwtttlllfyyymmbbbuullcdddzhohheeooppppwwwwuuuccdddbbiiiooiggkxxxxeuuuubbbbeeenmmmhhhnnnnxxxttttbsqqqnnnnvvvhhhhoooovvvssshzzzlmmmmxxxkkkkjjjjsgjjrmmmfffnnnnoooonnnnwwwwmmytttyyyyuuuffwkkkddqqqqpgggppqvvooooobdddppffjjjjuuqnppppllzzzzttttzdddoooouuuugqdddttttqjjjjuuuuuiivvvvnnnnnnnmmmssssmmmqiffffrrccttttlllkkkbbbnnnnjrrrrrttttoccctngggppqnggggiiipssssccccyynnnngggttvvjccyyyffzzllyycccnllllvzzzlppullllvvvynnnnjjjjkkkwwwvvvlllrraajjjyxxtxaakkkkhhhhsssccppppuiiknocclllbbaaalhhhzhhhhyyymmdtttjkkkmmmmsuuzzzuuammmmuuummmcccclggccccllffnllllhhjoofjjjjccddyyyrrraaaauuuusssgqoobbbccixxbbswwwmrxxxyyyyooookkeeeggggssbhhhaaooooiiiimmzzzzcccxxxxhggpxxxxnppkkeevbbbbyywwnppppnnnnwwbbccmmggggeeeehhddccweeeedddxxxxaaajjjjjjlllrbllnwwwyyyyllllhcccrrsssjjjjlllliiffuuuunnzeeeeyyeeaawhhzoorrrrmmmcmmmmmmmfffffddeeeellnnnhhfnnnnooosssslllwwwwttrrgmmmiiivnnnhjjwwwwwsssswwwbbooaaizzyyyyxannnwwdddlllkmmmrzzzzxxxxssssgggzzzzhgqqllllwwjjqqqggarxxqqiiussshhaaaavykkhhhhhhzffffnttttwwwwrrjjjbbbggggqqqhhhhaaaaubwwwvtttjjzzffqvvvattttvvvozzdsssskkoooddqqmzzzkkkxxxxiiipppvsssssrguoderpppprrrrfffggxxeeeddddeeerrrryyyyeeeffffuucccppppaayhiicccchhhhvxxxuuooeeeeiiikkkgghhhbbijjxxxxiiidddtttbbbbzzffffvbaaiiikkkkmpjjgqqqaaaabjpllrrffaapppplwwwwwnnmmmuuuubbbbejpgsrttttjjoovnnnnaaaapptttthhhttttyyqqqiiimmmrrrrffffvvvllxxxtooooyyyffffiiiirrrwaaaattzzzzooodoooaaaappppbbbggggbbbbiiwwcrrhbbrrrrsxiiiisshhhhuuaaffffco",
                "ssssiiiijjjwrbbbvvvlllkkkkesssddcnoarrrbbooyyyydssszzzeeewwyllleeeeqqqqgggnnohheeeddctzzzjjjoooouuuuttttisllhkkkkzzzppjjrrrqffgggqqtttccnnnznnniiirrrrbbbxxxaaaaennbbbppppwwssgiiiidddqqqcccchhhllobbbbkffyfsssccdddjjjgggggrrjjhhhhkkkkyyaaaaaapfooopmmmmccccixxxxggggllnyygggccccwwwceeeeqqqkkkmmmmrxxxxiiidddhyyyymmmjjjjjjjjnnnneeemmmdrrrllkkkzzzoiiiihhhhpssbbbddddmoooookkkfjjjjjttpphppbbllaahhccjjjkkkkccmmcccyyyttaaammmmvvvoooomkkkiiiikkkaaallllqqqqqqttjjjllliaaakkkkceeekkkdhhhmmmuuuutttrrqqqqpxxxqqqxxtxxyyyykkkkrrllllttttlllluqqqqirrrkpppoooopppeussddkkiinnnnrrrqqqqkkkkbbbzzzvvnnttttbbtllkqooooxxxxnnnnqqqqeffffqqqqooddylzzxxrlkkkkpuuuuooffffllssswwwiiiizxxnnnttttvjjjjbbbzzzrrrrbbbbttddxxiiiirrzzzzjjjjxxxxpccciiiiisttttttjjbiiiqqqeeeekvvvvxxxhhxxgsspppbvvv",
                "aahhhhvvvviiiiaaabbbbmmmwwwwwzzkkkkyyhhzzzzkkkkceeoootttticuxiiwwwwpkmmhhssssxxwwwyxddiiffffffxyozzllllxxjdddqqqqfkkkvggzzzznnxxeeejjmmqqqwwwwfrrrrvvvnnnjeeeeccceelnnnswwqqqrrrunnnyyyaaaxxxxxxhhssssnnrhsssssssfrtttzzzkkkkbblhhttggggaaaeeehheeeesssswwwweeeeeernniiixxnnnqqqqaaaappjjjjfjjjjyyygggzzhhhpuuwccccxffffrurrrhhhhcccnbbbbppppkkkknnnbrrrrhhffffmmmmwrrsssspppooflmccczzzzjjujjcctttiirrzyyffffmmmmrrrccccppiiiuuuggggffsiiuuutooooooxxxmmmuuubbnnnnrrrrffzzzmqeeeelllfffkkkccjjjjjjjssqqqgggghhpuunnkkkjjjjvvyyyfffrllllppppllllgwwwwkkkmqqqqyyyllllbaaaayyhhhuuuwwwwggssvssrraavrrfkkqqqqssssffwwwiiibbbbqqqqejjjqqfffrrrocnquuuuhhhqqjjjjsyyysssskkjjnnnnmmmddddttttuuuddddmhhhhurrruuuurrdrrrrvvoozhuuiiipppttttvvvbbbbhhhyyyynnccccdddsfhhhhppppkkjjjggghhhhvvvwnnnnqqccccbbbffffllllllkkkmmmmttjjyyyxxxozapxxylbeqqqqppdjjjjnnnhhhxxxwbiiivvxxxlllggggbbbbaaqjkkkkggggxxxxhhhffffaamrruuuullllaaaahhhhkkhhhhvrrrrennoooappnnrrrrwwtttoooplllttttggkkccccooiiiicrrffnnnppeeeepppponnnfjjjdppprrkbhprrrrvvddddvvvvggseeffvvvvrrreefemmmmvnnntttthhhnfffsssszzzzxxxppbbxxxuuuxnnnnoqqqczzllllqqttsttttppprrmffggggrwcrrrrkggoootttjjjgfffwyyyyvvvssskkkllllmmmmbbbwwyyyyeekzfffyyyyppppggggfbbbbvvveeemmmmwwwjjjjccczzfffksssqqyyvvvvppppiiijjnnnjjjjoooouuuuvvvvxfffommmmjjoooosssyrrrgrrrlkkkkkkkvqqqqthhhhoaaaakkkkiiieuuuummmmxhhhhkkkksssswwwwqqttaxxxxfieeerrrxxxxffttttfooooiikkkaazhhhttjjuuybbccccsnkkggllllttttnnnnqqqxxxhwussxxnnnnzffyyppppggggwwllbbbbbbwwwweeggggwwwiiixxxxwwetttyyyoooottgzccccwwwwrrrhzzzeeeejjjjaaaaaeggglkkkwwwwymtkkkkeeehhyykhhhccufffjjmmmmiiibxxxxvvvvjqqqqjjjmmmmqqqqrrteeeiraccniiddddkkkkkvvllllaaoooeeeebqqwujjjjffppppmccccjjddddggppgvvvvlllooovvkkkppppnwwwyyyypwwwxxooooffffrrrtthhrrrrznnnnynnllzzzeggggoooymmmmmmjbbbbylsscyybbbeeexxzzzdeeebbbblllwppppxxxeeeeaeeewsxxxxfffllqqtttkkkggguuuudddaayyyyoopplllliiiccccxxlllllcccnmxxmmmeeeeccccfsswzzzzkkkksgggnnnnmjjjooiiighhpppeeeefoooohhhhccccykkkwbhaaaaelxxxmnnnkffzeeejjjrooooxxeeuuuunnngtttrrccccppwlffllllqqqqmmmmooogyyrrippppjjjpppcccjjzzzzrrmmmmssppppuuurrrrouddddonnnnjqqhxxeevvvvvxxddjddddmmmmhhhhzzzzhhhhycwwwooojjjqqqqggyyszzzwwwnppplqqqzzzzooooeeeevvvllliiiihhlaaaqqqqbbbbqqqtxcccwwwxxxxxsssnnnhhkuuujjvvvcjmdsssyyaaaavvvoooiiiilllbbrrrrrrrrddnnnnvvwwweookkkkfffvvvrrrrwwwwuujjjjjjwwweeeeeezyyyyddfiizzzzznvvvjjjirrrhhhkkkkthbsssnnnnccjjjjzzzzwwwiieeeeennnaazyyvvvvvxxxmmmppppbbbuusnuusghhhhkkeeeeiimmffffhhhhtttnnnnlqqqwwwwvvveeeefffkbwwwwssshhhraddiiiihhhidddddjjjjtmmqqqgvvvvccccppppdddssssggttyyyykkkkyytttoonyyyycccccccwwqqqrrrrlllaayyywwwbbbklllwwwwuuuwwwwccjjjaaeeepwwwwzzzqqqwppppjjjjuuuuyllgggxmmmmoooovvvooojffyyyrgggbbbbmmzzzqggrrttteeetppyyyppppmmmtfffllyeeeewvvvaappjjjkkjjjjxxxhhhhozzqqqqsssooottttrrrxxxxefffyyyyyyffnnnuuuippkeeehhhdvvvbbbbbbjppfflllllffaaalkkkppprdwwnvasssooottttaaaa"
        );
    }

    @Override
    public int complexity() {
        return 20;
    }

    @Override
    public String author() {
        return "Pavlo Reshetylo (Pavlo_Reshetylo@epam.com)";
    }
}
