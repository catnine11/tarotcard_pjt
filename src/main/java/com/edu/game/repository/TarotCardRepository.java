package com.edu.game.repository;

import com.edu.game.aggregate.CardName;
import com.edu.game.aggregate.Direction;
import com.edu.game.aggregate.TarotCard;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TarotCardRepository {
    private final Map<CardName, TarotCard> cardStorage;
    private static final String FILE_PATH = "src/main/java/com/edu/game/db/";

    public TarotCardRepository() {
        cardStorage = new HashMap<>();
        initializeCards();
    }

    private void initializeCards() {

        //0. Fool
        Map<String, String> foolUpright = new HashMap<>();
        foolUpright.put("오늘의운세", "새로운 일이 생기거나 새롭게 마음을 다지는 일이 있을 것입니다. 또는 예상치 못한 기회가 다가오고 있습니다. 열린 마음으로 새로운 미래를 향해 다가가는 것이 좋을 것 같습니다.\n " +
                "하지만 때로는 지나친 낙관주의나 무모함으로 인해 신중하지 못한 결정을 내릴 수 있으니 모험을 감수하되, 충분히 생각하고 계획하는 것도 중요합니다.\n");
        foolUpright.put("연애운", "예상치 못한 곳에서 사랑의 기회가 찾아올 수 있습니다. 새로운 환경이나 상황에서 만남이 이루어질 수 있습니다.\n");
        foolUpright.put("금전운", "재정적으로 새로운 기회를 탐색하거나 새로운 투자나 프로젝트를 시작할 수 있는 좋은 시기임을 나타냅니다.\n" +
                "이 카드는 때때로 무모함을 의미하기도 합니다. 새로운 기회를 잡기 위해 모험을 감수할 필요가 있지만, 신중한 계획 없이 행동하는 것은 피해야 합니다.\n");

        Map<String, String> foolReversed = new HashMap<>();
        foolReversed.put("오늘의운세", "무책임함이나 경솔함으로 인해 위험이 발생할 수 있습니다.\n " +
                "조심스럽고 신중한 태도가 필요한 시기일 수 있으며, 너무 가볍게 행동하거나 결정하는 것은 문제를 야기할 수 있습니다.\n");
        foolReversed.put("연애운", " 무모한 선택이나 위험한 상황에 빠질 수도 있으므로, 조심하고 안정된 판단력을 유지하는 것이 중요합니다. \n 감정을 잘 다루고, 안전한 선택을 통해 관계를 보호하는 것이 중요할 것입니다.\n");
        foolReversed.put("금전운", "생각치도 못한 일에 지갑이나 돈, 소중히 여기던 물건을 잃어버릴 수도 있습니다.\n " +
                "계획에 없었던 충동구매를 하거나 예상치 못한 금전 사기를 당할 수도 있으니 조심하세요.\n");

        Map<Direction, Map<String, String>> foolMeanings = new HashMap<>();
        foolMeanings.put(Direction.UPRIGHT, foolUpright);
        foolMeanings.put(Direction.REVERSED, foolReversed);

        TarotCard theFool = new TarotCard(CardName.THE_FOOL, foolMeanings);
        cardStorage.put(CardName.THE_FOOL, theFool);

        //1. Magician
        Map<String, String> magicianUpright = new HashMap<>();
        magicianUpright.put("오늘의운세", "이 카드는 새로운 시작과 성공적인 결과를 예고합니다.\n " +
                "오늘은 당신의 잠재력을 최대한 활용할 때이며, 그것은 새로운 직업 새로운 사업, 새로운 사랑 또는 다른 것일 수 있습니다. 오늘은 어떤 선택을 해야 할 것이고, 이것이 다가올 큰 변화를 가져올 수 있습니다.\n" +
                "스스로를 신뢰하고 행동하면 원하는 것을 얻을 수 있을 것입니다. 지금 당장 당신의 생각을 실행으로 옮기고, 목표를 실현시켜보세요.\n ");
        magicianUpright.put("연애운", "관계에서의 소통과 이해가 강조됩니다. 새로운 관계를 시작하거나 기존 관계를 강화하는 데 좋은 시기입니다. 진실성과 자신감이 관계를 더욱 돈독하게 만듭니다.\n" +
                "지금 연애 시작 전이라면, 그 사람을 향해 조금 더 적극적으로 다가가봐도 좋을 것 같습니다. \n");
        magicianUpright.put("금전운", "재정적인 기술과 능력이 강조되며, 새로운 수입원을 발견하거나 투자에서 좋은 결과를 기대할 수 있습니다. \n" +
                "하지만, 들어오는 만큼 쓰는 경향이 있으니 현명한 재정 관리가 중요합니다. 예전에 누군가에게 빌려준 돈이 있다면 돌려 받을 수도 있을 것 같습니다. \n");

        Map<String, String> magicianReversed = new HashMap<>();
        magicianReversed.put("오늘의운세", "이 카드는 주의가 필요하며, 내적인 변화와 조정이 필요함을 암시합니다.\n " +
                "자기조절력의 부족이나 에너지의 흐름에 제약이 생긴 다는 것을 의미합니다. 당신은 오늘 일부 어려움과 도전에 직면할 수 있으며, 자신의 잠재력을 충분히 발휘하기 어려울 수 있습니다.\n" +
                "지금은 내부 조정과 변화가 필요한 시기입니다. 스스로에게 주의를 기울여 내부 에너지 충전과 회복에 집중하세요. 또한, 오늘 무모한 결정을 할 수 있으니 주의하세요.\n");
        magicianReversed.put("연애운", "관계에서 오해나 소통의 문제가 발생할 수 있습니다. 감정을 솔직하게 표현하고 상대방의 입장을 이해하려는 노력이 필요합니다.\n" +
                "자기 중심적인 행동을 지양해야 하고, 외부의 영향에 쉽게 휘둘리고 있지는 않은지 생각해보세요.\n");
        magicianReversed.put("금전운", "재정적인 문제가 발생할 수 있는 시기입니다. 무리한 투자나 지출을 피하고, 신중한 재정 관리가 요구됩니다.");

        Map<Direction, Map<String, String>> magicianMeanings = new HashMap<>();
        magicianMeanings.put(Direction.UPRIGHT, magicianUpright);
        magicianMeanings.put(Direction.REVERSED, magicianReversed);

        TarotCard magician = new TarotCard(CardName.THE_MAGICIAN , magicianMeanings);
        cardStorage.put(CardName.THE_MAGICIAN , magician
        );

        //2. THE_HIGH_PRIESTESS
        Map<String, String> priestessUpright = new HashMap<>();
        priestessUpright.put("오늘의운세", "직관, 비밀, 잠재력, 지혜를 의미합니다. \n" +
                "이 카드는 당신이 내면의 목소리에 귀 기울이고, 직관을 신뢰해야 할 때임을 나타냅니다. 현재 상황에서 어떤 진실이나 중요한 정보가 숨겨져 있을 수 있으며, 이는 당신이 스스로 찾고 해석해야 할 필요가 있음을 시사합니다. \n" +
                "오늘은 자신을 믿고 조용히 내면의 지혜를 탐구하는 것이 중요하니 조용한 시간을 가져 명상하거나 통찰력을 찾아내세요. 직감에 따라 행동하고 결정하는 것이 좋습니다.\n");
        priestessUpright.put("연애운", "관계에서 균형과 조화를 유지하고, 직관에 귀기울이세요. 숨겨진 감정이나 욕구를 이해하는 것이 중요합니다.\n" +
                "지금 연애 시작 전이라면, 짝사랑이나 연애경험부족으로 내성적으로 본인의 감정을 숨기기때문에 연애하기가 꽤 어려워 보입니다.");
        priestessUpright.put("금전운", "직관을 따르세요. 투자나 지출에 대한 신중한 고려가 필요하며, 숨겨진 기회를 찾을 수 있습니다.\n");

        Map<String, String> priestessReversed = new HashMap<>();
        priestessReversed.put("오늘의운세", "내면의 안정성이나 직관력에 제약이 생길 수 있습니다. 감정적인 혼란이나 의문이 발생할 수 있으며, 외부 요소들로부터 영향을 받아 결정하기 어려울수 있습니다.\n" +
                "만약 감정적인 혼란이 있다면 조심스럽게 상황을 평가하고 외부 요소들로부터 영향을 받지 않도록 하세요. 조용한 공간에서 명확한 생각을 가지고 분석해보거나 도움을 청하는 것도 좋은 방법일 수 있습니다.\n");
        priestessReversed.put("연애운", "관계에서 의사소통의 부족이나 오해가 발생할 수 있습니다. 감정을 숨기지 말고 솔직하게 표현하는 것이 중요합니다.\n" +
                "현재 이루어질 수 없는 사랑을 하거나, 연인이 신경질적인 태도를 보이거나 불만이 많고, 질투나 의심을 할 수 있는 상황이 생길 수도 있습니다.\n");
        priestessReversed.put("금전운", "재정적 문제나 어려움을 겪을 수 있습니다. 돈과 관련된 결정을 서두르지 마록 신중하게 생각할 필요가 있습니다.\n");

        Map<Direction, Map<String, String>> priestessMeanings = new HashMap<>();
        priestessMeanings.put(Direction.UPRIGHT, priestessUpright);
        priestessMeanings.put(Direction.REVERSED, priestessReversed);

        TarotCard priestess = new TarotCard(CardName.THE_HIGH_PRIESTESS , priestessMeanings);
        cardStorage.put(CardName.THE_HIGH_PRIESTESS , priestess);

        //3. THE_EMPRESS
        Map<String, String> empressUpright = new HashMap<>();
        empressUpright.put("오늘의운세", "풍요와 창조성을 상징하며, 여성성과 자연의 힘을 나타냅니다.\n" +
                " 오늘은 자연스럽고 풍요로운 날이 될 것으로 예상됩니다. 창조적인 에너지가 높아져 새로운 아이디어나 프로젝트를 시작하기에 좋은 시기일 수 있습니다. 주변 사람들에게 영감과 지원을 줄 수 있습니다.");
        empressUpright.put("연애운", "안정적이고 성숙한 관계를 의미합니다. 상호 존중과 이해가 연애의 핵심이며, 깊은 감정적 유대감을 나눌 수 있습니다.");
        empressUpright.put("금전운", "재정적인 안정과 현명한 재정 관리를 상징합니다. 장기적인 투자와 절약을 통해 재정적 안정을 추구해야 합니다.");

        Map<String, String> empressReversed = new HashMap<>();
        empressReversed.put("오늘의운세", "오늘 당신은 에너지가 저하되거나 창의성에 제약이 생길 수 있습니다. \n" +
                "몸과 마음의 균형 유지를 위해 안정화되고 충전된 환경에서 휴식하고 회복하세요. 다른 사람들에 대한 의존도를 줄이고 자신의 행동에 대한 자신을 가지세요.");
        empressReversed.put("연애운", "감정적인 불안정이나 관계의 불균형을 나타냅니다. 상대방과의 소통 부족이나 이해 부족이 문제가 될 수 있습니다.");
        empressReversed.put("금전운", "재정적인 문제나 불안정을 나타냅니다. 무리한 지출이나 재정 관리의 부족이 문제가 될 수 있습니다.");

        Map<Direction, Map<String, String>> empressMeanings = new HashMap<>();
        empressMeanings.put(Direction.UPRIGHT, empressUpright);
        empressMeanings.put(Direction.REVERSED, empressReversed);

        TarotCard empress = new TarotCard(CardName.THE_EMPRESS , empressMeanings);
        cardStorage.put(CardName.THE_EMPRESS , empress);

        //4. THE_EMPEROR
        Map<String, String> emperorUpright = new HashMap<>();
        emperorUpright.put("오늘의운세", "통제력과 권위, 조직적인 구조와 안정성을 상징합니다. \n" +
                " 결단력 있고 지도자적인 자세로 상황을 통제할 수 있는 시기입니다. 당신은 목표를 설정하고 실행하기 위한 계획을 세우며, 주변에 안정성과 질서를 가져올 수 있습니다.\n" +
                "명확한 계획을 세우고 실행해나가세요. 안정성과 질서를 유지하며 주변 사람들에게 영감을 줄 수 있는 리더 역할을 맡아보는 것이 좋을 수 있습니다.");
        emperorUpright.put("연애운", "안정적이고 신뢰할 수 있는 관계를 상징합니다. 파트너와의 관계에서 리더십을 발휘하거나, 책임감 있는 태도가 필요합니다.");
        emperorUpright.put("금전운", "재정적 안정과 효율적인 자산 관리를 나타냅니다. 투자나 재정 계획에서 체계적이고 실용적인 접근이 필요합니다.");

        Map<String, String> emperorReversed = new HashMap<>();
        emperorReversed.put("오늘의운세", "통제력의 상실이나 권위의 문제가 발생할 수 있다는 것을 상징합니다. \n" +
                "오늘 자기 통제와 조직력에 제약이 생길 수 있으며, 외부 요소로부터 영향을 받아 결정하기 어려울 수 있습니다. \n" +
                "스스로를 돌보고 내부에서 강화하는 시간이 필요합니다. 자기 통제와 조직력의 회복에 초점을 맞추어야 합니다. 외부 요소들에 의존하지 않고 스스로의 가치와 능력에 신뢰할 필요가 있습니다.");
        emperorReversed.put("연애운", "관계에서의 지나친 지배욕이나 독단적인 태도가 문제가 될 수 있습니다. 파트너와의 균형과 소통이 중요합니다.");
        emperorReversed.put("금전운", "재정적으로 불안정하거나 무모한 결정을 내릴 수 있는 시기입니다. 재정 관리에 대한 재평가가 필요합니다.");

        Map<Direction, Map<String, String>> emperorMeanings = new HashMap<>();
        emperorMeanings.put(Direction.UPRIGHT, emperorUpright);
        emperorMeanings.put(Direction.REVERSED, emperorReversed);

        TarotCard emperor = new TarotCard(CardName.THE_EMPEROR , emperorMeanings);
        cardStorage.put(CardName.THE_EMPEROR , emperor);

        //5. THE_HIEROPHANT
        Map<String, String> hierophantUpright = new HashMap<>();
        hierophantUpright.put("오늘의운세", "전통과 지식, 신념 체계와 교리를 상징합니다. \n" +
                "오늘은 학습과 교육, 혹은 스스로를 개선하기 위한 시간을 가질 수 있는 시기입니다. 당신은 자신의 가치관과 신념에 충실하며, 지혜롭고 올바른 결정을 내릴 수 있습니다.\n" +
                "학습과 교육 기회를 찾아보거나 현재 상황에서 옳고 그름에 대한 판단력을 강화하세요. 자신의 신념 체계와 일관되는 행동으로 인해 안정감과 평온함을 느낄 수 있습니다.\n");
        hierophantUpright.put("연애운", "헌신과 신뢰가 중요한 역할을 합니다. 깊은 정서적 연결과 전통적인 관계의 가치를 강조하며, 장기적인 관계를 위한 안정성을 상징합니다.\n");
        hierophantUpright.put("금전운", "안정과 전통적인 투자 방법이 유리하다는 것을 나타냅니다. 재정적 안정을 위해 신중하고 계획적인 접근이 필요합니다.\n" +
                "전문가의 조언을 구하거나, 신뢰할 수 있는 재정기관과ㅏ 협력하는 것이 좋습니다. 규칙을 준수하고 체계적으로 재정을 관리하면 안정성과 번영을 이룰 수 있을 것입니다.\n");

        Map<String, String> hierophantReversed = new HashMap<>();
        hierophantReversed.put("오늘의운세", "관습에 얽매이거나 개인적인 신념과 가치관을 무시하는 경향이 있다는 것을 상징합니다. \n" +
                "다양한 관점과 창의적인 접근 방식을 통해 문제를 해결하는 것이 중요합니다. 자유로운 사고와 독립적인 판단력을 발휘하세요.\n" +
                "다른 사람들의 의견도 존중하며 융통성 있게 대처하세요. 새로운 아이디어와 관점들에 열려있으며, 자신만의 길과 목소리를 찾아내기 위해 모범사례 외에도 탐색하는 것이 좋습니다.");
        hierophantReversed.put("연애운", "연애에서 불안정성이나 전통적인 관계의 가치에 대한 도전을 상징합니다. 관계에서의 의사소통 문제나 신뢰 상실을 암시할 수 있습니다.");
        hierophantReversed.put("금전운", "재정적으로는 불안정하거나 비전통적인 투자가 문제를 일으킬 수 있습니다. 재정 계획의 재검토가 필요할 수 있습니다.");

        Map<Direction, Map<String, String>> hierophantMeanings = new HashMap<>();
        hierophantMeanings.put(Direction.UPRIGHT, hierophantUpright);
        hierophantMeanings.put(Direction.REVERSED, hierophantReversed);

        TarotCard hierophant = new TarotCard(CardName.THE_HIEROPHANT , hierophantMeanings);
        cardStorage.put(CardName.THE_HIEROPHANT , hierophant);

        //6. THE_LOVERS
        Map<String, String> loversUpright = new HashMap<>();
        loversUpright.put("오늘의운세", "사랑과 조화, 선택과 결합을 상징합니다. \n" +
                "오늘은 당신이 사랑과 관계에 대한 긍정적인 영향력을 느끼며, 조화롭고 균형 잡힌 상호작용을 가질 수 있는 시기입니다. 당신은 중요한 선택이나 결정을 내리는 데 있어서도 안목을 가지고 행동할 수 있습니다.");
        loversUpright.put("연애운", "강력한 사랑과 파트너십을 상징합니다. \n 진정한 감정의 교류와 강한 유대감이 형성됩니다. 이 카드는 조화로운 관계의 발전을 나타냅니다.");
        loversUpright.put("금전운", "재정적인 결정이나 선택에 있어 중요한 변화의 시기입니다.\n 감정적인 면을 고려하여 재정적 결정을 내리는 것이 중요합니다.");

        Map<String, String> loversReversed = new HashMap<>();
        loversReversed.put("오늘의운세", "갈등이나 분란, 선택의 어려움이 있다는 것을 상징합니다. \n" +
                "오늘은 관계나 결합에 있어서 어려움이 발생할 수 있으며, 내부적인 갈등이나 모순된 욕구들로 인해 선택하기 어려울 수 있습니다.");
        loversReversed.put("연애운", "관계의 갈등이나 불안정성을 나타냅니다. \n 파트너십에서의 오해나 의사소통 문제가 발생할 수 있습니다. 관계에서의 중요한 선택에 직면할 수도 있습니다.");
        loversReversed.put("금전운", "재정적으로 잘못된 결정을 내릴 위험이 있음을 경고합니다. 금전적인 문제에 있어서 감정에 치우치지 않도록 주의가 필요합니다.");

        Map<Direction, Map<String, String>> loversMeanings = new HashMap<>();
        loversMeanings.put(Direction.UPRIGHT, loversUpright);
        loversMeanings.put(Direction.REVERSED, loversReversed);

        TarotCard lovers = new TarotCard(CardName.THE_LOVERS , loversMeanings);
        cardStorage.put(CardName.THE_LOVERS , lovers);

        //7. THE_CHARIOT
        Map<String, String> chariotUpright = new HashMap<>();
        chariotUpright.put("오늘의운세", "성공과 승리, 목표 달성을 상징합니다. \n" +
                "오늘은 당신이 결단력과 의지력을 발휘하여 원하는 목표를 향해 전진할 수 있는 시기입니다. 당신은 자기 통제와 균형을 유지하며 어려움을 극복하고 성취감을 느낄 수 있습니다.");
        chariotUpright.put("연애운", "적극적이고 확실한 태도로 인해 연애에서 긍정적인 변화가 기대됩니다. 새로운 관계를 시작하거나 기존 관계를 강화시킬 수 있습니다.");
        chariotUpright.put("금전운", "재정적으로 진전을 이룰 수 있는 좋은 기회가 있습니다. 적극적인 투자나 재정 관리가 긍정적인 결과를 가져올 수 있습니다.");

        Map<String, String> chariotReversed = new HashMap<>();
        chariotReversed.put("오늘의운세", "통제력 상실이나 방황, 목표에 도달하기 어려움이 있다는 것을 상징합니다. \n 오늘은 자기 통제와 집중력에 제약이 생길 수 있으며, 방황하거나 혼란스러운 상황에 처할 수 있습니다." +
                "스스로를 다시 조정하고 내부적인 갈등을 해결하는 시간이 필요합니다. 명확한 목표를 재설정하고 집중력과 결단력 회복에 중력하세요.");
        chariotReversed.put("연애운", "관계에서 방향성을 잃거나 갈등이 발생할 수 있습니다. 상대방과의 소통에 더 주의를 기울일 필요가 있습니다.");
        chariotReversed.put("금전운", "재정 관리에 있어서 신중하지 못하거나, 무리한 지출로 인해 재정적 어려움을 겪을 수 있습니다. 지출을 조절하고 신중한 결정이 필요합니다.");

        Map<Direction, Map<String, String>> chariotMeanings = new HashMap<>();
        chariotMeanings.put(Direction.UPRIGHT, chariotUpright);
        chariotMeanings.put(Direction.REVERSED, chariotReversed);

        TarotCard chariot = new TarotCard(CardName.THE_CHARIOT , chariotMeanings);
        cardStorage.put(CardName.THE_CHARIOT , chariot);

        //8. STRENGTH
        Map<String, String> strengthUpright = new HashMap<>();
        strengthUpright.put("오늘의운세", "용기와 인내, 내면적인 힘을 상징합니다. \n " +
                "오늘은 당신이 어려움을 극복하고 도전에 맞서기 위한 강인한 의지력을 가지고 있는 시기입니다. 당신은 자신의 내면적인 힘과 자아를 발견하며, 어떤 상황에서도 차분하고 지혜롭게 대처할 수 있습니다.\n" +
                "도전에 맞서며 어려운 상황에서도 평정심과 지혜로운 판단력으로 행동하세요. 자신의 내면적인 힘이 무엇보다 중요하며, 그것에 기반하여 성공과 성취를 이룰 수 있습니다.\n");
        strengthUpright.put("연애운", "강한 유대감과 상호 존중을 의미합니다. 관계에서의 균형과 성숙함이 강조됩니다.");
        strengthUpright.put("금전운", "재정적으로 안정되고 통제력을 유지할 수 있음을 나타냅니다. 위험한 투자보다는 안정적인 관리가 중요함을 시사합니다.");

        Map<String, String> strengthReversed = new HashMap<>();
        strengthReversed.put("오늘의운세", "자신감 부족이나 내면적인 약점을 경험할 수 있다는 것을 상징합니다. \n" +
                "오늘은 어려움에 대한 도전감이 부족하거나 자아 의심이 생길 수 있습니다. 자기 조절과 내부적인 강인함을 다시 찾아야 할 때일 수 있습니다.\n" +
                "스스로를 견고하게 다지고 강화하는 시간이 필요합니다. 도전에 대한 의지력과 용기를 찾아내기 위해 개인적인 성장과 발전에 집중하세요. 자신의 잠재력과 내부적인 힘이 있는 것을 믿어야 합니다.");
        strengthReversed.put("연애운", "관계에서의 불균형이나 갈등을 상징합니다. 강압적이거나 지배적인 태도로 인한 문제가 발생할 수 있습니다.");
        strengthReversed.put("금전운", "재정적으로 불안정하거나 통제력을 잃을 위험이 있음을 나타냅니다. 무모한 지출이나 투자에 주의가 필요합니다.");

        Map<Direction, Map<String, String>> strengthMeanings = new HashMap<>();
        strengthMeanings.put(Direction.UPRIGHT, strengthUpright);
        strengthMeanings.put(Direction.REVERSED, strengthReversed);

        TarotCard strength = new TarotCard(CardName.STRENGTH , strengthMeanings);
        cardStorage.put(CardName.STRENGTH , strength);

        //9. THE_HERMIT
        Map<String, String> hermitUpright = new HashMap<>();
        hermitUpright.put("오늘의운세", "내면 탐구와 혼자서의 시간, 지혜와 깨달음을 상징합니다. \n" +
                "오늘은 고요하고 조용한 환경에서 자기 발견과 성장을 위한 시간을 가질 수 있는 시기입니다. 당신은 외부의 소음과 간섭에서 독립하여 내면의 지혜를 얻을 수 있습니다.");
        hermitUpright.put("연애운", "혼자만의 시간을 갖고 자신에 대해 깊이 생각하는 시기입니다. \n" +
                "현재 관계에서 깊은 수준의 연결을 추구하거나, 싱글이라면 자기 자신과의 관계를 강화하는 데 중점을 둘 필요가 있습니다.");
        hermitUpright.put("금전운", "재정적으로는 신중한 접근을 취할 필요가 있습니다. 지출을 줄이고 절약하는 데 집중하며, 장기적인 재정 계획을 세우는 것이 좋습니다.");

        Map<String, String> hermitReversed = new HashMap<>();
        hermitReversed.put("오늘의운세", "고독감이나 분리, 내적인 집중의 어려움이 있다는 것을 상징합니다. \n" +
                "오늘은 혼자서의 시간을 갖기 어렵거나 외부 요소들로 인해 내적인 탐구에 방해를 받을 수 있습니다.\n" +
                "주변 사람들과 소통하고 연결되는 것도 중요합니다. 다른 사람들로부터 영감과 지원을 받으며 외부 활동에 참여함으로써 새로운 관점과 통찰력을 얻어내세요. 내적인 집중에 어려움이 있더라도 주변 사람들과 함께 배우고 성장할 수 있는 기회를 찾아보세요.");
        hermitReversed.put("연애운", "고립감이나 관계에서의 단절감을 느낄 수 있습니다. 소통과 이해를 위해 더 많은 노력이 필요합니다. 혼자만의 시간을 너무 많이 갖는 것도 문제가 될 수 있습니다.");
        hermitReversed.put("금전운", "무분별한 지출이나 재정 관리의 부족을 경고합니다. 재정적으로 무리한 결정을 피하고, 신중한 계획이 필요합니다.");

        Map<Direction, Map<String, String>> hermitMeanings = new HashMap<>();
        hermitMeanings.put(Direction.UPRIGHT, hermitUpright);
        hermitMeanings.put(Direction.REVERSED, hermitReversed);

        TarotCard hermit = new TarotCard(CardName.THE_HERMIT , hermitMeanings);
        cardStorage.put(CardName.THE_HERMIT , hermit);

        //10. WHEEL_OF_FORTUNE
        Map<String, String> wheelUpright = new HashMap<>();
        wheelUpright.put("오늘의운세", "운명의 바퀴, 행운과 기회, 변화의 시기를 상징합니다. \n" +
                "오늘은 좋은 운명적인 사건이 일어날 수 있는 시기입니다. 행운과 기회가 당신을 찾아오며, 긍정적인 변화와 성장의 기회를 제공할 수 있습니다.");
        wheelUpright.put("연애운", "로운 연애의 시작이나 기존 관계의 긍정적 변화를 나타냅니다. 우연한 만남이나 새로운 사랑의 기회가 찾아올 수 있습니다.");
        wheelUpright.put("금전운", "긍정적인 변화가 예상됩니다. 뜻밖의 수입이나 재물의 증가, 투자 성과 등이 있을 수 있습니다.");

        Map<String, String> wheelReversed = new HashMap<>();
        wheelReversed.put("오늘의운세", "불안정성이나 예상치 못한 변화에 대한 저항을 상징합니다. \n" +
                "당신의 오늘의 운세는 예기치 않은 상황이나 어려움에 직면할 수 있으며, 일시적인 불확실성을 경험할 수 있습니다.\n" +
                "현재 상황에서 안정감을 찾도록 노력하세요. 변경에 저항하지 말고 유연하게 대처하는 자세를 갖추어야 합니다. 일시적인 불확실성 속에서도 자신의 내부 안정감과 지속적인 발전을 위해 노력하세요.");
        wheelReversed.put("연애운", "관계에서의 어려움이나 오해가 발생할 수 있습니다. 기존 관계의 위기나 새로운 관계의 시작에 어려움이 있을 수 있습니다.");
        wheelReversed.put("금전운", "재정적 어려움이나 손실을 경험할 수 있습니다. 불필요한 지출이나 예기치 않은 금전적 문제가 생길 수 있습니다.");

        Map<Direction, Map<String, String>> wheelMeanings = new HashMap<>();
        wheelMeanings.put(Direction.UPRIGHT, wheelUpright);
        wheelMeanings.put(Direction.REVERSED, wheelReversed);

        TarotCard wheel = new TarotCard(CardName.WHEEL_OF_FORTUNE , wheelMeanings);
        cardStorage.put(CardName.WHEEL_OF_FORTUNE , wheel);

        //11. JUSTICE
        Map<String, String> justiceUpright = new HashMap<>();
        justiceUpright.put("오늘의운세", "공정과 균형, 정의와 진리를 상징합니다. \n" +
                "오늘은 공정한 대우를 받을 수 있는 시기입니다. 정직하고 균형 잡힌 행동과 결정을 통해 원하는 결과를 얻을 수 있으며, 과거의 행동에 대한 보상이나 벌을 경험할 수도 있습니다.");
        justiceUpright.put("연애운", "관계에서의 정직함과 공정함이 강조됩니다. \n" +
                "상호 존중과 균형 잡힌 관계가 중요하며, 양측의 필요와 기대를 공정하게 다루어야 합니다.");
        justiceUpright.put("금전운", "재정적 결정에 있어서 정의와 공정성이 요구됩니다. \n" +
                "예산 관리와 지출에 대한 책임감 있는 태도가 필요하며, 재정적 균형을 유지하는 것이 중요합니다.");

        Map<String, String> justiceReversed = new HashMap<>();
        justiceReversed.put("오늘의운세", "불공정함이나 불균형, 부당한 처벌을 상징합니다. \n" +
                "오늘 당신의 운세는 공정하지 않은 상황이나 부당함에 직면할 수 있으며, 과거의 행동에 따른 결과로 인해 불만족스러운 경험을 할 수도 있습니다.");
        justiceReversed.put("연애운", "관계에서의 불공정함이나 부정직을 나타낼 수 있습니다.\n 상대방과의 불균형, 신뢰의 부족, 또는 오해가 관계에 영향을 미칠 수 있습니다.");
        justiceReversed.put("금전운", "재정적 불균형이나 부정직한 금전 거래를 나타낼 수 있습니다. 무분별한 지출이나 재정 관리의 부족이 경고의 신호일 수 있습니다.");

        Map<Direction, Map<String, String>> justiceMeanings = new HashMap<>();
        justiceMeanings.put(Direction.UPRIGHT, justiceUpright);
        justiceMeanings.put(Direction.REVERSED, justiceReversed);

        TarotCard justice = new TarotCard(CardName.JUSTICE , justiceMeanings);
        cardStorage.put(CardName.JUSTICE , justice);

        //12. THE_HANGED_MAN
        Map<String, String> hManUpright = new HashMap<>();
        hManUpright.put("오늘의운세", "희생과 깨달음, 관점 변화를 상징합니다.\n" +
                " 오늘은 당신이 일시적인 희생과 어려움을 경험하며, 새로운 관점과 깨달음을 얻을 수 있는 시기입니다. 당신은 현재의 상황에서 벗어나고 싶은 욕구를 뒤로하고 내부적인 성장과 변화에 초점을 맞출 수 있습니다.");
        hManUpright.put("연애운", "사랑과 관계에서 새로운 관점이나 이해가 필요함을 의미합니다. 관계에서의 희생과 이해가 중요한 시기입니다. 상대방과의 소통을 강화할 필요가 있습니다.");
        hManUpright.put("금전운", "재정적인 면에서 기존의 방식을 재고하고 새로운 전략을 모색할 시기입니다. 지출을 줄이거나 투자에 대해 신중하게 생각해볼 필요가 있습니다.");

        Map<String, String> hManReversed = new HashMap<>();
        hManReversed.put("오늘의운세", "저항이나 고착된 사고 패턴, 변화에 대한 거부를 상징합니다. \n" +
                "오늘은 새로운 관점을 받아들이기 어렵거나 현재의 상황에서 벗어나지 못하는 느낌을 경험할 수 있습니다. 자신의 사고 방식과 태도에 대해 검토할 필요가 있습니다.");
        hManReversed.put("연애운", "관계에서 소통 부족이나 오해가 발생할 수 있음을 나타냅니다. 관계에서 자기중심적인 태도를 버리고 상대방을 이해하려는 노력이 필요합니다.");
        hManReversed.put("금전운", "재정적으로 불안정하거나 재정 관리에 소홀함을 나타낼 수 있습니다. 더 신중하고 현명한 재정 계획이 필요합니다.");

        Map<Direction, Map<String, String>> hManMeanings = new HashMap<>();
        hManMeanings.put(Direction.UPRIGHT, hManUpright);
        hManMeanings.put(Direction.REVERSED, hManReversed);

        TarotCard hMan = new TarotCard(CardName.THE_HANGED_MAN , hManMeanings);
        cardStorage.put(CardName.THE_HANGED_MAN , hMan);

        //13. DEATH
        Map<String, String> deathUpright = new HashMap<>();
        deathUpright.put("오늘의운세", "변화와 변형, 새로운 시작을 상징합니다. \n" +
                "오늘은 당신의 삶에서 큰 전환점이나 변화의 시기일 수 있습니다. 과거의 패턴과 상황을 뒤로하고 새로운 가능성과 성장을 위한 기회를 받아들일 준비가 되어 있는 시기입니다.\n" +
                "지금까지의 패턴과 제약에서 벗어나며 자신의 성장과 발전을 위한 기회를 잡아내세요. 마음을 열고 긍정적인 태도로 다가가면서 삶에서 큰 전환점들을 만들어 나갈 수 있습니다.");
        deathUpright.put("연애운", "관계에서 중대한 변화가 있을 수 있습니다. 이는 관계의 종결 또는 새로운 시작을 의미할 수 있으며, 감정적으로 도전적일 수 있습니다.");
        deathUpright.put("금전운", "재정적으로 중요한 변화의 시기를 암시합니다. \n" +
                "기존의 재정 관리 방식을 재평가하고, 새로운 재정 계획을 수립할 필요가 있을 수 있습니다.");

        Map<String, String> deathReversed = new HashMap<>();
        deathReversed.put("오늘의운세", "저항이나 변화에 대한 두려움, 과거에 매몰되어 있는 상태를 상징합니다. 오늘은 변화에 대한 거부감이나 어려움을 겪을 수 있으며, 과거의 패턴에 묶여있어 성장과 발전이 어려울 수 있습니다.\n" +
                "현재 상황에서 벗어날 방법과 자신의 관점을 바꾸기 위해 노력해야 합니다. 자신의 두려움과 제약 사항들을 인식하고 이를 극복하기 위해 개인적인 성장 및 발전에 주력하세요. 거부보다는 받아들임과 유연성으로써 변화와 전환 기회를 찾아내세요.");
        deathReversed.put("연애운", "관계에서 변화를 거부하거나 필요한 조정을 하지 않는 것을 의미합니다. 이는 관계의 발전을 저해하거나, 필요한 변화를 무시하는 결과를 초래할 수 있습니다.");
        deathReversed.put("금전운", "재정적 문제를 해결하려는 노력의 부족을 나타냅니다. 기존의 재정 관리 방식에 변화를 주지 않고, 문제를 그대로 방치할 위험이 있습니다.");

        Map<Direction, Map<String, String>> deathMeanings = new HashMap<>();
        deathMeanings.put(Direction.UPRIGHT, deathUpright);
        deathMeanings.put(Direction.REVERSED, deathReversed);

        TarotCard death = new TarotCard(CardName.DEATH , deathMeanings);
        cardStorage.put(CardName.DEATH , death);

        //14. TEMPERANCE
        Map<String, String> temperanceUpright = new HashMap<>();
        temperanceUpright.put("오늘의운세", "조화와 균형, 자제력을 상징합니다. \n" +
                "오늘은 당신이 내면적인 조화와 외부 세계 간의 균형을 찾을 수 있는 시기입니다. 절제와 자제력을 발휘하며 갈등과 불균형을 조정할 수 있습니다. 인내심과 타협의 필요성을 알아차리고 그로 인해 긍정적인 결과를 얻게 됩니다.\n" +
                "내부적인 평온과 외부 세계 간의 조화를 유지하기 위해 절제와 자제력을 발휘하세요. 갈등 상황에서 중재자 역할로서 타협과 협조를 통해 긍정적인 결과를 이끌어 낼 수 있습니다.");
        temperanceUpright.put("연애운", "관계에서 조화와 이해가 중요합니다. 감정의 균형을 유지하며 서로의 차이를 존중하는 것이 중요합니다.");
        temperanceUpright.put("금전운", " - 지출과 저축 사이의 균형을 찾아야 합니다. 재정적 안정성을 위해 절제된 소비가 필요합니다.");

        Map<String, String> temperanceReversed = new HashMap<>();
        temperanceReversed.put("오늘의운세", "불균형이나 과도함, 통제의 상실을 상징합니다. \n" +
                "오늘은 내부적인 조화와 외부 세계 간의 균형 유지에 어려움을 겪거나 자제력이 부족한 느낌일 수 있습니다. 지나치거나 과도한 행동으로 인해 문제가 발생할 수 있으므로 주의가 필요합니다.\n" +
                "지나치거나 과도한 행동에 주의하고 자신의 행동 패턴 및 습관들에 대한 검토가 필요합니다. 안정성과 절충안을 찾기 위해 다른 사람들로부터 도움이 될 수 있는 관점들도 듣고 받아들여보세요.");
        temperanceReversed.put("연애운", " - 관계에서의 불균형이나 갈등이 생길 수 있습니다. 서로의 차이를 인정하고 해결하기 위한 노력이 필요합니다.");
        temperanceReversed.put("금전운", " - 재정 관리에 어려움을 겪을 수 있습니다. 지출이 수입을 초과하거나 불필요한 지출이 많을 수 있습니다.");

        Map<Direction, Map<String, String>> temperanceMeanings = new HashMap<>();
        temperanceMeanings.put(Direction.UPRIGHT, temperanceUpright);
        temperanceMeanings.put(Direction.REVERSED, temperanceReversed);

        TarotCard temperance = new TarotCard(CardName.TEMPERANCE , temperanceMeanings);
        cardStorage.put(CardName.TEMPERANCE , temperance);

        //15. THE_DEVIL
        Map<String, String> devilUpright = new HashMap<>();
        devilUpright.put("오늘의운세", "유혹과 얽매임, 자유로움의 제약을 상징합니다. \n" +
                "오늘은 유혹에 빠지거나 제한적인 상황에서 벗어나기 어려울 수 있는 시기입니다. 자신의 욕망과 의존 관계들을 돌아보고, 그것들로부터 자유를 찾아내기 위한 결단력과 강인함을 발휘해야 합니다.");
        devilUpright.put("연애운", "지나치게 집착하거나 의존적인 관계를 나타낼 수 있습니다. 감정적으로 불안정하거나 질투와 소유욕이 강한 관계가 될 수 있으니, 건강한 경계를 설정하는 것이 중요합니다.");
        devilUpright.put("금전운", "탐욕이나 물질에 대한 과도한 집착을 경고합니다. \n" +
                "재정적으로 위험한 결정을 내리거나 도박과 같은 위험한 투자에 끌릴 수 있습니다. 재정 관리에 신중함이 필요합니다.");

        Map<String, String> devilReversed = new HashMap<>();
        devilReversed.put("오늘의운세", "해방과 자유, 의존 관계에서 벗어남을 상징합니다. \n" +
                "오늘은 제한된 상황에서 벗어나고 새로운 자유와 독립성을 찾아갈 수 있는 시기입니다. 과거의 유혹에 묶여있던 것들로부터 해방되며, 자신의 욕망과 가치를 재조정할 기회가 주어집니다.\n" +
                "현재 상황에서 새로운 가능성과 독립성에 집중하세요. 과거의 유혹이나 의존 관계에서 벗어났으므로 새롭게 시작할 수 있는 기회가 주어진 것입니다. 개인적인 성장 및 발전을 위해 적극적으로 움직여보세요.");
        devilReversed.put("연애운", "관계에서의 억압이나 집착에서 벗어나려는 시도를 나타냅니다. 자유로운 관계를 추구하거나 독립적인 개인으로서의 성장을 나타낼 수 있습니다.");
        devilReversed.put("금전운", "재정적으로 자유를 얻거나 탐욕에서 벗어나려는 시도를 나타냅니다. 재정적 독립을 추구하거나 물질적인 것보다는 정신적인 가치에 더 중점을 두게 될 수 있습니다.");

        Map<Direction, Map<String, String>> devilMeanings = new HashMap<>();
        devilMeanings.put(Direction.UPRIGHT, devilUpright);
        devilMeanings.put(Direction.REVERSED, devilReversed);

        TarotCard devil = new TarotCard(CardName.THE_DEVIL , devilMeanings);
        cardStorage.put(CardName.THE_DEVIL , devil);

        //16. THE_TOWER
        Map<String, String> towerUpright = new HashMap<>();
        towerUpright.put("오늘의운세", "파괴와 변화, 급작스러운 사건을 상징합니다. \n" +
                "오늘은 예상치 못한 변화나 돌발적인 사건을 경험할 수 있는 시기입니다. 현재의 구조와 패턴이 무너지며 새로운 시작과 재구성의 기회가 주어집니다. 이 변화를 받아들이고 적극적으로 대응하는 것이 중요합니다.\n" +
                "만약 당신이 예상치 못한 변화에 직면한다면, 오늘은 그것에 대처하기 위해 준비하세요. 불확실성과 도전을 받아들이고 자신의 탄력성을 발휘하여 새로운 시작을 추구하세요. 현재의 구조와 패턴들이 무너져내린다 해도 긍정적인 관점에서 학습하고 성장할 수 있습니다.");
        towerUpright.put("연애운", "관계에서 갑작스런 변화가 일어날 수 있습니다. 오해나 갈등이 발생할 가능성이 있으며, 이는 관계를 재평가하는 계기가 될 수 있습니다. 솔직한 대화가 중요합니다.");
        towerUpright.put("금전운", "금전적으로 불안정한 상황이 발생할 수 있습니다. 예기치 못한 지출이나 손실이 있을 수 있으므로 재정 관리에 주의해야 합니다. 변화에 대비하는 태도가 필요합니다.");

        Map<String, String> towerReversed = new HashMap<>();
        towerReversed.put("오늘의운세", "피해 회복과 재구축, 내부적인 변화를 상징합니다.\n" +
                " 당신의 오늘의 운세는 과거에 겪었던 파괴적인 사건이나 어려움에서 벗어나 회복과 재생의 기회를 얻을 수 있는 시기입니다. 내부적인 성장과 변화를 추구하며 지속 가능한 기초 위에 새로운 구조를 세울 수 있습니다.");
        towerReversed.put("연애운", "관계의 문제가 해결되거나, 새로운 단계로 나아갈 수 있는 기회가 있습니다. 과거의 오해나 갈등을 극복하고 관계를 강화할 수 있는 시기입니다.");
        towerReversed.put("금전운", "금융 상황이 점차 안정되어 가고 있을 수 있습니다. 과거의 재정적 어려움에서 벗어나 새로운 기회를 모색할 때입니다. 재정 계획을 재정비하는 것이 좋습니다.");

        Map<Direction, Map<String, String>> towerMeanings = new HashMap<>();
        towerMeanings.put(Direction.UPRIGHT, towerUpright);
        towerMeanings.put(Direction.REVERSED, towerReversed);

        TarotCard tower = new TarotCard(CardName.THE_TOWER , towerMeanings);
        cardStorage.put(CardName.THE_TOWER , tower);

        //17. THE_STAR
        Map<String, String> starUpright = new HashMap<>();
        starUpright.put("오늘의운세", "희망과 영감, 신뢰와 안정을 상징합니다. \n" +
                "오늘은 당신에게 희망의 빛과 새로운 가능성이 비추는 시기입니다. 내면적인 조화와 꿈을 추구하며, 자신과 세계에 대한 믿음과 긍정적인 에너지를 가질 수 있습니다. \n" +
                "미래에 대한 희망과 목표를 설정하고 그것들을 실현하기 위해 움직여보세요.");
        starUpright.put("연애운", "사랑과 관계에서 희망적인 전환점을 맞이할 수 있습니다. \n" +
                "싱글인 경우 새로운 사랑을 만날 기회가 있으며, 커플인 경우 관계가 더욱 깊어질 수 있습니다.");
        starUpright.put("금전운", "재정적으로 밝은 전망을 암시합니다. 투자나 저축에서 긍정적인 결과를 기대할 수 있으며, 재정적 안정을 찾게 될 것입니다.");

        Map<String, String> starReversed = new HashMap<>();
        starReversed.put("오늘의운세", "저하와 의욕 상실, 불확실성을 상징합니다. \n" +
                "오늘은 희망이 감소하거나 영감을 잃은 상태일 수 있으며, 자신의 목표나 꿈에 대한 동기부여가 어려울 수 있습니다. 하지만 지금은 포기하지 않고 다시 동기부여를 찾고자 하는 시간입니다.\n" +
                "현재의 어려움들 속에서도 힘내서 포기하지 마세요. 자신의 목표와 꿈에 대한 동기부여를 찾아내기 위해 복원력 있는 활동이나 사람들로부터 지원 받으세요. 어려운 시간일수록 새로운 희망의 빛을 발견할 수 있는 기회가 주어진다는 것을 기억하세요.");
        starReversed.put("연애운", "관계에서 오해나 실망이 생길 수 있습니다. 소통의 부족이나 감정적 거리감이 문제가 될 수 있습니다.");
        starReversed.put("금전운", ": 재정적으로 어려움을 겪을 수 있습니다. 불필요한 지출이나 투자 실패에 주의해야 합니다.");

        Map<Direction, Map<String, String>> starMeanings = new HashMap<>();
        starMeanings.put(Direction.UPRIGHT, starUpright);
        starMeanings.put(Direction.REVERSED, starReversed);

        TarotCard star = new TarotCard(CardName.THE_STAR , starMeanings);
        cardStorage.put(CardName.THE_STAR , star);

        //18. THE_MOON
        Map<String, String> moonUpright = new HashMap<>();
        moonUpright.put("오늘의운세", "본능과 직관, 내면의 갈등을 상징합니다.\n" +
                "오늘은 깊은 자기반성과 내면의 감정에 집중하는 시간을 가져보세요. 감정의 불안정성이나 혼란스러움을 경험할 수 있지만, 그것을 통해 자신을 더 깊게 이해하고 성장하는 계기가 될 수 있습니다.\n" +
                "또한 꿈이나 무의식의 메세지에 주목해보세요. 그것들은 종종 당신의 진실이나 욕구에 대한 중요한 통찰력을 제공할 수 있습니다. ");
        moonUpright.put("연애운", "감정의 혼란과 오해를 상징합니다. 파트너와의 의사소통에 더욱 주의를 기울이고, 감정을 솔직하게 표현하는 것이 중요합니다.");
        moonUpright.put("금전운", "재정적으로는 불확실성과 혼란이 있을 수 있습니다. 투자나 중요한 재정 결정을 내릴 때 신중을 기하고, 모든 옵션을 면밀히 검토해야 합니다.");

        Map<String, String> moonReversed = new HashMap<>();
        moonReversed.put("오늘의운세", "부정적인 감정이나 불안을 극복하고 현실을 더욱 명확히 인식하게 되는 시점을 의미합니다.\n" +
                "오늘은 복잡하고 혼란스러웠던 감정이나 상황에서 벗어나는 시점일 수 있습니다. 지금까지 피하거나 감추어왔던 부정적인 감정이나 두려움을 해소하고 진실을 인식하는 단계에 있을 수 있습니다.\n" +
                "이 과정은 어렵고 힘들 수 있지만 결국 더 맑고 밝은 상태로 나아가게 될 것입니다. 진실을 직시하고 감정을 극복하는 과정을 통해 당신은 더 강한 사람이 될 것입니다.");
        moonReversed.put("연애운", "연애에서의 오해와 혼란이 해소되며, 관계에서 더 깊은 이해와 소통이 이루어질 수 있습니다. 감정을 명확히 표현하고 상호 이해를 높일 수 있는 좋은 기회입니다.");
        moonReversed.put("금전운", "재정적인 문제에서 오는 혼란이 해소되고, 더 안정적인 재정 상태로 이동할 수 있습니다. 신중한 계획과 결정이 긍정적인 결과를 가져올 것입니다.");

        Map<Direction, Map<String, String>> moonMeanings = new HashMap<>();
        moonMeanings.put(Direction.UPRIGHT, moonUpright);
        moonMeanings.put(Direction.REVERSED, moonReversed);

        TarotCard moon = new TarotCard(CardName.THE_MOON , moonMeanings);
        cardStorage.put(CardName.THE_MOON , moon);

        //19. THE_SUN
        Map<String, String> sunUpright = new HashMap<>();
        sunUpright.put("오늘의운세", "행복과 태양 같은 빛, 성공과 만족을 상징합니다. \n" +
                "오늘은 밝고 긍정적인 에너지가 넘치며, 내면의 기쁨과 외부 세계 간의 조화를 경험할 수 있는 시기입니다. 자신에게 자부심을 가지고 주변 사람들과 함께 나눌 수 있는 기쁨을 느끼며 삶의 목표를 달성하는 데 큰 도움이 될 것입니다.\n" +
                "긍정적인 마음가짐으로 삶을 즐기며 주변 사람들과 나누어 보세요. 성공적인 결과와 만족감을 경험할 수 있는 시기입니다.");
        sunUpright.put("연애운", "사랑과 관계에서 긍정적인 에너지가 넘칩니다. 새로운 사랑을 만날 수 있는 기회가 있거나, 기존의 관계가 더욱 깊어지고 화목해집니다. 상대방과의 소통이 잘 되며, 서로에 대한 이해와 존중이 강화됩니다.");
        sunUpright.put("금전운", "재정적으로 안정적인 시기를 나타내며, 수입이 증가하거나 새로운 재정적 기회가 생길 수 있습니다. 투자나 사업에서 좋은 소식이 있을 수 있으며, 경제적으로 풍요로운 시기입니다.");

        Map<String, String> sunReversed = new HashMap<>();
        sunReversed.put("오늘의운세", "음영과 어둠, 자아 의심을 상징합니다. \n" +
                "오늘은 내부적인 어려움이나 음영된 면모들로 인해 행복감이 어려울 수 있습니다. 자아 신뢰와 긍정적인 에너지를 회복하기 위해 내면 탐구와 자기 성찰에 주력하세요.");
        sunReversed.put("연애운", "관계에서의 오해나 갈등이 발생할 수 있습니다. 의사소통 문제나 상대방과의 불일치가 관계에 영향을 미칠 수 있으며, 관계를 재평가할 필요가 있습니다. 상대방을 이해하고 소통하는 노력이 필요합니다.");
        sunReversed.put("금전운", "재정적인 어려움이나 불안정함을 경험할 수 있습니다. 예상치 못한 지출이나 소득 감소가 발생할 수 있으며, 재정적인 계획을 재검토할 필요가 있습니다. 신중한 재정 관리가 필요한 시기입니다.");

        Map<Direction, Map<String, String>> sunMeanings = new HashMap<>();
        sunMeanings.put(Direction.UPRIGHT, sunUpright);
        sunMeanings.put(Direction.REVERSED, sunReversed);

        TarotCard sun = new TarotCard(CardName.THE_SUN , sunMeanings);
        cardStorage.put(CardName.THE_SUN , sun);

        //20. JUDGEMENT
        Map<String, String> judgementUpright = new HashMap<>();
        judgementUpright.put("오늘의운세", "부활과 재생, 새로운 시작을 상징합니다. \n" +
                "오늘은 과거의 결정과 행동들에 대한 평가와 변화를 경험할 수 있는 시기입니다. 자신의 내면에서 새로운 인식과 깨달음이 일어나며, 새로운 기회와 도전에 대한 준비를 할 수 있습니다. \n" +
                "지난 경험들을 토대로 더 나은 방향으로 나아갈 수 있는 기회가 주어진 것입니다. 지금까지의 경험이나 깨달음으로부터 배워서 새로운 도전과 기회에 임하십시오. 자신의 내면에서 영감을 받고 현재 상황에서 최선의 판단력을 발휘하세요.");
        judgementUpright.put("연애운", "개인적인 관계에서는 갱신과 재평가의 시기를 의미합니다. 관계에 있어서 중요한 결정을 내려야 할 수도 있으며, 이는 종종 자신과 파트너의 진정한 가치와 욕구를 재평가하는 과정을 포함합니다.");
        judgementUpright.put("금전운", "재정적 평가와 재구성의 시기를 나타냅니다. 지금까지의 재정 관리 방식을 재평가하고, 필요하다면 새로운 방향으로 나아갈 준비를 해야 합니다. 재정적으로 새로운 시작을 의미할 수 있습니다.");

        Map<String, String> judgementReversed = new HashMap<>();
        judgementReversed.put("오늘의운세", "자기 비판과 무감각함, 결정의 연기를 상징합니다. \n" +
                "오늘은 과거의 판단과 결정들을 되돌아보고 그 결과에 대해 반성할 필요가 있을 수 있습니다. 자신에게서 비판적인 태도를 버리고 실수와 실패를 받아들여야 합니다. 더 나은 선택과 변화를 위해 내부적인 개선 작업을 진행하는 것이 중요합니다.\n" +
                "만약 자기 비판이나 결정 연기와 같은 어려움들 속에서 있다면, 현재 상황에서 지난 결정들에 대해 반성하고 배우세요. 실수와 실패도 성장할 수 있는 기회입니다. 자신을 너그럽게 받아들이고 개선하기 위한 조치를 취하세요.");
        judgementReversed.put("연애운", "관계에서는 오해나 갈등이 발생할 수 있음을 암시합니다. 소통의 부족이나 오해로 인한 문제가 생길 수 있으니, 관계에서 소통과 이해를 강화하는 것이 중요합니다.");
        judgementReversed.put("금전운", "재정적으로는 부주의하거나 잘못된 결정으로 인한 손실을 경고합니다. 재정 관리에 있어서 더욱 신중하고 조심스러워야 할 시기입니다.");

        Map<Direction, Map<String, String>> judgementMeanings = new HashMap<>();
        judgementMeanings.put(Direction.UPRIGHT, judgementUpright);
        judgementMeanings.put(Direction.REVERSED, judgementReversed);

        TarotCard judgement = new TarotCard(CardName.JUDGEMENT , judgementMeanings);
        cardStorage.put(CardName.JUDGEMENT , judgement);

        //21. THE_WORLD
        Map<String, String> worldUpright = new HashMap<>();
        worldUpright.put("오늘의운세", "완성과 성취, 만족감을 상징합니다. 오늘은 여태까지의 노력과 여정이 성공적으로 완료되었음을 나타냅니다. \n" +
                "당신은 목표를 달성하고 삶의 한 구절을 마무리할 준비가 되어 있습니다. 오늘은 그 결과에 대한 기쁨과 만족감을 느끼며 새로운 도전에 대한 준비를 시작할 수 있는 시기입니다. 자신의 업적들에 자부심을 가지고 앞으로 나아가세요.");
        worldUpright.put("연애운", "조화롭고 균형 잡힌 관계를 나타냅니다. 현재 관계가 깊어지거나 새로운 관계가 시작될 수 있습니다. 상호 이해와 존중이 강조됩니다.");
        worldUpright.put("금전운", "재정적 안정과 성공을 상징합니다. 투자의 결실을 보거나 예상치 못한 수익이 발생할 수 있습니다. 재정 관리에 탁월한 시기입니다.");

        Map<String, String> worldReversed = new HashMap<>();
        worldReversed.put("오늘의운세", "미완성과 차질, 잠재적인 제약을 상징합니다. 오늘은 목표를 달성하는 과정에서 어려움이나 지연이 발생할 수 있는 시기입니다. \n" +
                "아직 완전한 성취로까지 도달하지 못한 상태일 수 있으며, 제약 요소들이 일시적으로 당신을 방해할 수도 있습니다.\n" +
                "만약 아직 목표를 완전하게 이루지 못한다면, 지금은 잠시 멈추어서 현재 상황에서 필요한 조치와 개선 사항들에 대해 다시 평가해 보세요. 제약 요소들에 의해 방해될 수도 있으므로 융통성 있게 대처하세요. 완전한 성공까지 도달하기 위해서 추가적인 노력과 조정이 필요할 수 있습니다.");
        worldReversed.put("연애운", "관계에서의 불화나 오해가 발생할 수 있습니다. 커뮤니케이션 부족이나 불안정함이 문제가 될 수 있으며, 관계를 재평가할 필요가 있습니다.");
        worldReversed.put("금전운", "재정적 문제나 손실이 발생할 수 있습니다. 불필요한 지출이나 투자 손실에 주의해야 합니다. 재정 관리에 더욱 신중을 기울일 필요가 있습니다.");

        Map<Direction, Map<String, String>> worldMeanings = new HashMap<>();
        worldMeanings.put(Direction.UPRIGHT, worldUpright);
        worldMeanings.put(Direction.REVERSED, worldReversed);

        TarotCard world = new TarotCard(CardName.THE_WORLD , worldMeanings);
        cardStorage.put(CardName.THE_WORLD , world);




    }


    public List<TarotCard> getAllCards(){
        return new ArrayList<>(cardStorage.values());
    }


    public void saveResultToFile(String fileName, CardName name, Direction direction, String keyword, String meaning) {
        File directory = new File(FILE_PATH);
        if(!directory.exists()){
            directory.mkdirs();
        }

        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH + fileName, true), StandardCharsets.UTF_8))) {
            writer.write("키워드: " + keyword);
            writer.newLine();
            writer.write("카드 이름: " + name);
            writer.newLine();
            writer.write("방향: " + direction);
            writer.newLine();
            writer.write("의미: " + meaning);
            writer.newLine();
            writer.write("============================================================================");
            writer.newLine();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장에 오류가 발생했습니다.");
        }
    }
}
