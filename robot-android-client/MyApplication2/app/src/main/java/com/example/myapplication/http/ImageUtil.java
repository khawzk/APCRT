package com.example.myapplication.http;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;

public class ImageUtil {

    /**
     * Base64转换为图片服务
     * targetPath  输出视频文件路径,不需要文件名
     * */
    public static void base64ToImg(String base64,String targetPath){
        File file = null;
        FileOutputStream fops = null;
        base64 = base64.replace("data:image/jpeg;base64,","");
        byte[] buff = DatatypeConverter.parseBase64Binary(base64);
        try {
            fops = new FileOutputStream(new File(targetPath));
            fops.write(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------"+"图片转换完成"+"--------------------------------");
    }

    public static void main(String[] args)
    {
        String base64="iVBORw0KGgoAAAANSUhEUgAAAbAAAAEgCAYAAADVKCZpAAAABHNCSVQICAgIfAhkiAAAAAlwSFlz\n" +
                "AAALEgAACxIB0t1+/AAAADh0RVh0U29mdHdhcmUAbWF0cGxvdGxpYiB2ZXJzaW9uMy4yLjIsIGh0\n" +
                "dHA6Ly9tYXRwbG90bGliLm9yZy+WH4yJAAAgAElEQVR4nO3deVhV1foH8C9CmmaQIqiBYkYZM8rU\n" +
                "oJWW5pBkSoqXbnbV0NRMra7dnylqzmapadxOetPCtK5akChlmmaKAyhONKgJCuq96M0ppyOs3x+v\n" +
                "DCdQOQhnneH7eR4fOOdsDq+Lvfd71tprv8tJKaVARERkY2rpDoCIiKgqmMCIiMgmMYEREZFNYgIj\n" +
                "IiKbxARGREQ2iQmMiIhsEhMYERHZJCYwIiKySUxgRERkk5jAiIjIJjGBERGRTWICIyIim8QERkRE\n" +
                "NokJjIiIbBITGBER2SQmMCIisklMYEREZJOYwIiIyCYxgRERkU1iAiMiIpvEBEZERDaJCYyIiGwS\n" +
                "ExgREdkkJjAiIrJJTGBERGSTmMCIiMgmMYEREZFNYgIjIiKbxARGREQ2iQmMiIhsEhMYERHZJCYw\n" +
                "IiKySUxgRERkk5jAiIjIJrnoDqCmNGrUCC1atNAdBhGRTcnJycHJkyd1h1EpdpvAWrRogYyMDN1h\n" +
                "EBHZlPDwcN0hVBqHEImIyCYxgRERkU1iAiMiIptkNQmssLAQrVu3xtNPP13utcuXL6NPnz7w9fVF\n" +
                "VFQUcnJyLB8gERFZFatJYHPmzIGfn1+Fry1cuBANGjTAwYMHMXLkSIwePbpGYliyBGjRAqhVS74u\n" +
                "WVIjv8ZusL3Mw/YyD9vLfA7XZsoKHD16VHXo0EGtW7dOdevWrdzrnTp1Ulu2bFFKKWU0GpW7u7sq\n" +
                "Kiq64XuGhYWZFUNSklL16ikFlP6rV0+ep/LYXuZhe5mH7WW+6mozc8+dOlnFNPoRI0ZgxowZOHfu\n" +
                "XIWv5+fno1mzZgAAFxcXuLm54dSpU2jUqFG1xTBmDHDhgulzFy4AI0cCd95Zbb/GbowcWXF7jRkD\n" +
                "xMXpicmacf8yD/cv811vH7PnNtOewFatWgVPT0+EhYVhw4YNt/ReBoMBBoMBAFBQUGDWzx45UvHz\n" +
                "BQXAM8/cUlgOIhvAauTmnsf48bpjsT65ucXfPQAgtuR57l+VZQBwDLm54P51Hbm5DQF0B3APgHcB\n" +
                "jAJw/XObPdCewDZv3oyUlBSsXr0aly5dwtmzZ/H8888jKSmpZBsvLy8cPXoU3t7euHr1Ks6cOQN3\n" +
                "d/dy7xUfH4/4+HgA5t+M17x52ZNMIQBnAECTJkBqalX+Z/atWzfgxIniR98BeBKAP9zdgYQEwMlJ\n" +
                "X2zWaNGisvtXKe5fFTPdvwBAjmsfHyawP7t6FZg9W445pYqf9S55vXlzLWFZhu4xzLK+//77Cq+B\n" +
                "zZs3Tw0aNEgppdTSpUvVc889d9P3urVrYEaOud+EaXslKECpWrXkcceOSh0+rDtC68JrOuZhe1XO\n" +
                "nj1KRURI+4SFKVWnTnF7fe4Q18CsZhbin40bNw4pKSkAgAEDBuDUqVPw9fXFu+++i2nTplX774uL\n" +
                "AwwGwNVVHvv4yGN7HTu+VcXt5eMjj318pJcxfz6Qng4EBgJz5wKFhVrDtBrF7VV82fbuu7l/3Uhx\n" +
                "e3l6yuPGjdleZV2+LCMdbdoAOTnA558DO3YAEyaUbuMQ5zDdGbSmVPVTxOjRSjk7G6s5GvuWkJBg\n" +
                "8jg3V6nOneWT4EMPKZWdrScua7RkibTLL7/ojsQ2rFsn7bVxo+5IrEd6ulL+/tIuzz+v1MmTpa/t\n" +
                "2yfPx8R8XuX3Zw+MHFrz5sDq1cAnnwC//AKEhgKTJwNGo+7IiGzXH38Ao0YBDz8MnD0r104//RSo\n" +
                "YDqAw2ACoxrh5AT89a9AdjbQowfw1ltAeDiQmak7MiLbs24dEBQEvPce8PLLwP79QNeuuqPSjwmM\n" +
                "alTjxjI+/+WXMmU8Kgp4803g4kXdkRFZv9OngZdeAp58EnBxATZulOvMxdfqHR0TGFlEjx7SG3vx\n" +
                "RWD6dCAkBPjhB91REVmv5GTA3x/4+GNg9Ghg927g0Ud1R2VdmMDIYu66C1iwAPjuO7l35bHHgCFD\n" +
                "ZDyfiMR//wvExsqHPk9PYNs2YNo0oG5d3ZFZHyYwsrgnngD27gVGjAD++U+Zcr96te6oiPRSCkhK\n" +
                "Avz8ZMh90iSZGh8Wpjsy68UERlrccYdckN6yRWoBdusmkz5OntQdGZHlHTlSegy0agVkZUkNw9tu\n" +
                "0x2ZdWMCI60efBDYuRMYNw5YtkzG/L/4omxJHCL7VVQEJCYCAQEyQWPOHGDTJumF0c0xgZF2depI\n" +
                "BYHMTKke0KcP8OyzwLFjuiMjqjm//go8/rhcB37oIZkaP3w44OysOzLbwQRGViM4WMpQzZwJfPON\n" +
                "9MYWLmRvjOzL1avAjBkyE3fvXpll+M03sgAlmYcJjKyKiwvw+utyYIeGAgMHyj0wv/2mOzKiW7d7\n" +
                "t9wLOXo00KVL6a0lXL2hapjAyCr5+gLr18ssxR07ZKbie++xODDZpkuXSqvR5OcDy5cDK1cCTZvq\n" +
                "jsy2MYGR1apVCxg0SD6lduggdeAeeUSuFRDZii1bgNatpR5oXJzsz7166Y7KPjCBkdXz9ga+/hr4\n" +
                "7DPg0CE5GUycCFy5ojsyous7fx549VWgbVvgwgUgLU2WHGrYUHdk9oMJjGyCkxPQt698eo2JkbWQ\n" +
                "wsNleJHI2qxdK8V3338fGDoU2LcPeOop3VHZHyYwsikeHtITS0kB/vc/uY/sjTfkEy6Rbr//DvTv\n" +
                "D3TqJLeH/PCDJLE779QdmX3SnsAuXbqEyMhIhISEICAgAAkJCeW2WbRoETw8PBAaGorQ0FAsWLBA\n" +
                "Q6RkTbp3l2thAwcC77wjU/A3bNAdFTmylSvl1o9PPgH+8Q+pptG2re6o7Jv2BFanTh2sX78eu3fv\n" +
                "RlZWFtLS0rB169Zy2/Xp0wdZWVnIysrCwIEDNURK1sbNDfjwQ5mtCADt28ukjzNn9MZFjuXECRnW\n" +
                "7tULaNJEhrWnTAFuv113ZPZPewJzcnJC/fr1AQBGoxFGoxFOvCmCzNC+PbBnj9w/tmCBlOVZtUp3\n" +
                "VGTvlAIWL5Ze16pVkrS2b5dJRmQZ2hMYABQWFiI0NBSenp7o2LEjoqKiym2zYsUKBAcHIyYmBkeP\n" +
                "HtUQJVmzevWkgkd6OtCggQwx/uUvsogmUXXLzZUbkV98URJYVpYMG7L4rmVZRQJzdnZGVlYW8vLy\n" +
                "sH37duzbt8/k9e7duyMnJwd79uxBx44d0a9fvwrfx2AwIDw8HOHh4SjgmcshRUZKTcUJE+RmUX9/\n" +
                "YOlSlqOi6lFUBMybJ738zZvl+x9+AB54QHdkjskqElixu+66C+3bt0daWprJ8+7u7qhTpw4AYODA\n" +
                "gcjMzKzw5+Pj45GRkYGMjAx4eHjUeLxknWrXlur2O3cCLVtKTyw6GsjL0x0Z2bKff5YVkV95RSZn\n" +
                "7NsnU+RrWdVZ1LFob/qCggKcPn0aAHDx4kWsXbsWD/zp48zx48dLvk9JSYEf1xqgSggMlCoI774L\n" +
                "rFsnvbEPP5RP0USVZTTK9a2QELkPcfFiYM0aWTmB9NKewI4fP4727dsjODgYERER6NixI55++mmM\n" +
                "GzcOKSkpAIC5c+ciICAAISEhmDt3LhYtWqQ3aLIZzs7AyJFSHDgiAhg8WFaEPnhQd2RkC3btkmHp\n" +
                "MWOkF//TT8ALL7D4rrVw0R1AcHAwdu3aVe75iRMnlnw/depUTJ061ZJhkZ25917gu+9keZbXXpMq\n" +
                "CW+/DYwYIRXwicq6dEmuo86cKTfPr1gB9OypOyr6M+09MCJLcXKSG5+zs6VSwhtvAA8/LL0zomI/\n" +
                "/ijDhdOmSW8rO5vJy1oxgZHD8fICvvoKWLYMyMkB2rSR2oqXL+uOjHQ6dw4YNgxo104KRX/7LfCv\n" +
                "f8ltGWSdmMDIITk5AX36yKfr2Fipbh8WBmzbpjsy0iEtTSb9fPCBVJDfuxfo2FF3VHQzTGDk0Bo1\n" +
                "Aj79FEhNlRJUDz0k64798YfuyMgSTp0C+vWTm5LvuEPu7Zo9G7hWHIisHBMYEYCuXaU48ODBsvJz\n" +
                "UJBMvSf7pFTpje6ffSarJe/aJR9gyHYwgRFd4+oqQ0gbN8rMxCefBF56Cbh2myLZiePHpfDuc88B\n" +
                "zZoBGRkyI/VarQSyIUxgRH/y6KPA7t3A3/8uF/H9/YHkZN1R0a1SCvj4Y/l7rlkDTJ8ObN0qMw7J\n" +
                "NjGBEVWgbl05wW3bJvcB9eghkz3++1/dkVFVHD4st0707y9rxxV/QOE9gLaNCYzoBsLDS4eYvvwS\n" +
                "8PMDkpJYHNhWFBYCc+bIDMNt24DEROD774H779cdGVUHJjCim7jtttKL/K1aAX/9K9CtG3DkiO7I\n" +
                "6Eays+WerhEjgMceK52kw+K79oN/SqJK8vcHNm2ST/QbN8qSGomJLA5sbYxGYNIkWVjy11+lx5ya\n" +
                "KhM2yL4wgRGZwdkZGD5cltJ48EFgyBDg8cflREn6ZWbKsO/YscCzz0ovLC6OxXftFRMYURXcc09p\n" +
                "qaG9e2Um24wZwNWruiNzTBcvAqNHS+X4goLSUmGenrojo5rEBEZURU5OwN/+Jp/yu3SRE2hUlMxw\n" +
                "I8v54YfSDxADBsjf45lndEdFlsAERnSLmjaV5Tb+/W9Z9bl4CIvFgWvW2bMyhPvYYzLbcN06wGAA\n" +
                "7rpLd2RkKUxgRNXAyQmIiZEFD+PiZBJBaKisCE3Vb/VqmUTz4YdSu3LPHqBDB91RkaVpT2CXLl1C\n" +
                "ZGQkQkJCEBAQgISEhHLbXL58GX369IGvry+ioqKQk5Nj+UCJKqFhQ2DRIqlufuEC0LatVDc/f153\n" +
                "ZPbh5Eng+eflNgZXV/mAMGuWFOIlB6Q0KyoqUufOnVNKKXXlyhUVGRmp0tPTTbaZP3++GjRokFJK\n" +
                "qaVLl6revXvf9H3DwsLMjiUpSSlXV6UAo/Lxkcd0fUlJSvn4KAUksL0qcPasUsOGKQUo1aKFUqNH\n" +
                "K9WokTy++262180kJSnl6Snt1bixtKWHh1IuLkolJCh16ZLuCK3PtGnSXsDnVT4mq3Lu1EV7Aivr\n" +
                "jz/+UK1bt1Zbt241eb5Tp05qy5YtSimljEajcnd3V0VFRTd8L3P/CElJStWrV/zHNypAHvMkUzHT\n" +
                "9kpge93Apk1KNW1a3Fal/9he12e6f5X+u+cepfbs0R2ddUpKUur220sTWFX3MVtKYE5K6S+KU1hY\n" +
                "iLCwMBw8eBBDhw7F9OnTTV4PDAxEWloavL29AQD33nsvtm3bhkaNGl33PcPDw5GRkVHpGFq0AHJz\n" +
                "yz/v7CwX6cnU8eNy4VzkAvABAPj4yCrHZMrHp+LKHWyvil3veGzevOLn6c9t9gWA3gDM38fMPXfq\n" +
                "ZBWlLJ2dnZGVlYXTp0/j2Wefxb59+xAYGGj2+xgMBhgMBgBAQUGBWT9renL5FoAkx8JCWfSQTOXl\n" +
                "3Q2gybVHuwF8DEAOoPHjNQVlxUr3r+I2OwGA7XU9pSdiZwB3A/gDwP9w5Ajb63qkzTwADAWQU/K8\n" +
                "XZc8090F/LMJEyaomTNnmjxniSFEuZZjOiQGyPNU6vx5pV599c9DO2yvm+H+ZR62l/lM2+zzKreZ\n" +
                "LQ0hap+FWFBQgNPXVgy8ePEi1q5diwceeMBkm+joaCxevBgAsHz5cnTo0AFO1VwbZvJkoF490+fq\n" +
                "1ZPnSXz3nVT1njMH6NhRlhwpi+11fdy/zMP2Mt/kycDtt5s+Z/dtpjuD7t69W4WGhqqgoCAVEBCg\n" +
                "JkyYoJRSauzYsSo5OVkppdTFixdVTEyMuvfee1VERIQ6dOjQTd+3qrMQOauuvN9/V6p/f/k0d999\n" +
                "Sv3wgzzP9jIP28s8bC/zcRainbiVP0JCQkL1BWLjvvxSZtA5Oyv15ptKXbhQfhu2l3nYXuZhe1Xe\n" +
                "vn2SwGJiPq/ye9hSArOKSRxkff7zH+CVV6Q8UmgosGoV0KaN7qiIiEppvwZG1kUp4JNPZOXh5GQZ\n" +
                "P9++ncmLiKwPe2BU4sgRYNAgKYP08MPAwoXAn+bTEBFZDfbACEVFwPz5Uhx10yZg7lz5yuRFRNaM\n" +
                "PTAH98svwMCBwI8/ytR4g0Hu6CcisnbsgTkooxGYNk0WAty3D/j4Y+Cbb5i8iMh2sAfmgHbtkpVr\n" +
                "d+0CevUC5s0DmjS5+c8REVkT9sAcyKVLwJgxQEQEcOwYsHy5/GPyIiJbxB6Yg9i8WXpdv/wCvPii\n" +
                "LALYsKHuqIiIqo49MDt3/jwwfDjQrp30wL75Rq53MXkRka1jArNj33wjxXfnzQOGDZPJGp066Y6K\n" +
                "iKh6MIHZof/9T4YJO3eWivHF93bVr687MiKi6sMEZmdWrAD8/YGkJJmwsWsX8MgjuqMiIqp+nMRh\n" +
                "J44fl2HClSuB1q2lHFRoqO6oiIhqDntgNk4pYNEi6XWlpsrNydu3M3kRkf1jD8yG5eQA8fHA2rVA\n" +
                "27bAggVAq1a6oyIisgztPbCjR4+iffv28Pf3R0BAAObMmVNumw0bNsDNzQ2hoaEIDQ3FxIkTNURq\n" +
                "PQoLZVJGYCCQni6FeDduZPIiIseivQfm4uKCWbNmoU2bNjh37hzCwsLQsWNH+Pv7m2zXrl07rFq1\n" +
                "SlOU1uOnn6T47pYtMsvwww+B5s11R0VEZHnae2BNmzZFm2urJd55553w8/NDfn6+5qisj9Eoi0uG\n" +
                "hgI//yyLTq5ezeRFRI5LewIrKycnB7t27UJUVFS519LT0xESEoIuXbpg//79GqLTZ+dOqV/41ltA\n" +
                "jx5Adjbw178CTk66IyMi0kf7EGKx8+fPo1evXpg9ezZcXV1NXmvTpg1yc3NRv359rF69Gj169MCB\n" +
                "AwfKvYfBYIDBYAAAFBQUWCTumnTxIjBhAvDOO4CHB/Dll5LAiIjISnpgRqMRvXr1QlxcHHr27Fnu\n" +
                "dVdXV9S/Vkaia9euMBqNOHnyZLnt4uPjkZGRgYyMDHh4eNR43DVp0yYZLpw+XapqZGczeRERlaU9\n" +
                "gSmlMGDAAPj5+WHUqFEVbnPixAkopQAA27dvR1FREdzd3S0ZpsWcPQsMHQo8+qhc91q7VqbHN2ig\n" +
                "OzIiIuuifQhx8+bN+PTTTxEUFITQa3ffTpkyBUeOHAEADB48GMuXL0diYiJcXFxQt25dLFu2DE52\n" +
                "eAFozRpg0CAgLw8YMQKYNAm44w7dURERWSftCaxt27YlvavrGTZsGIYNG2ahiCzv1Clg5Ejg00+l\n" +
                "osaWLcCDD+qOiojIumkfQnRkSgFffAH4+QFLlwJjx8qMQyYvIqKb094Dc1THjsm1rq++AsLCgO++\n" +
                "A4KDdUdFRGQ72AOzMKWAhQtlqDAtDZgxA9i6lcmLiMhc7IFZ0G+/AS+9BKxfDzz2GPDRR8B99+mO\n" +
                "iojINrEHZgGFhcDs2UBQELBjB/DPf0oSY/IiIqo69sBq2P79wIABwLZtQLdukry8vXVHRURk+9gD\n" +
                "qyFXrgBvvy2rIx88CCxZAnz9NZMXEVF1YQ+sBuzYIb2uvXuB2FhZu8vGK1sREVkd9sCq0YULwBtv\n" +
                "yH1cp04ByclyfxeTFxFR9WMPrJps2CAzDA8eBOLjZXq8m5vuqIiI7Bd7YLfozBlg8GCgfXu5x2v9\n" +
                "elklmcmLiKhmMYHdgtRUICBA7ud67TVgzx5JZEREVPOYwKqgoACIiwOeflqWOUlPl0Un69XTHRkR\n" +
                "keNgAjODUjIpw98f+Pe/gfHjgcxMIDJSd2RERI6HkzgqKS8PePllYNUqSVgLFwKBgbqjIiJyXNp7\n" +
                "YEePHkX79u3h7++PgIAAzJkzp9w2SikMHz4cvr6+CA4Oxs6dOy0WX1ERYDDIta5164B335X1upi8\n" +
                "iIj00p7AXFxcMGvWLGRnZ2Pr1q2YP38+srOzTbZZs2YNDhw4gAMHDsBgMODll1+ukViWLAFatAAm\n" +
                "TJCvs2YBTzwhqySHhcmNySNHAs7ONfLrbc6f22vJEt0RWTe2l3nYXuZbtUq+Ll/uIG2mrEx0dLT6\n" +
                "9ttvTZ6Lj49Xn332Wcnj+++/Xx07duyG7xMWFmbW701KUqpePaXkStf4a1+VqltXqY8+UqqoyKy3\n" +
                "s3um7ZWgAHmclKQ7MuvE9jIP28t8SUlK3X57cZt9XuU2M/fcqZNVXQPLycnBrl27EBUVZfJ8fn4+\n" +
                "mjVrVvLY29sb+fn5aNq0abX97jFjpJKGGFjyvIsLcPIkMH16tf0quzB9etn2kvHUCxekHePitIVl\n" +
                "tUz3r7YA5PGwYcDRo9rCslqm+5ecD7h/3diYMcClS6bP2XubWU0CO3/+PHr16oXZs2fD1dW1Su9h\n" +
                "MBhgMBgAAAUFBWb97JEjZR95lXx37hzwj39UKRwH8jiACQAUcnNldiaZys0t/i4IQK+S50+f5v51\n" +
                "c10AnAOwCrm5v3D/uo7c3JYAugNoAGArgN4A/nxusy9WkcCMRiN69eqFuLg49OzZs9zrXl5eOFrm\n" +
                "Y2peXh68vLzKbRcfH4/4+HgAQHh4uFkxNG9e9iTzNoCxJc//8otZb2X39u8HHn5YKu6LTwAkAAB8\n" +
                "fJjAKrJoUdn9axKAtwBw/7qeVq3KnngNAOIB9EW9ejIbuHFjfbFZm99/l0IKpko7Ac2bWzQci9Ke\n" +
                "wJRSGDBgAPz8/DBq1KgKt4mOjsa8efMQGxuLbdu2wc3NrVqHDwFg8mSpYSjDFoUA5MbkKVOA22+v\n" +
                "1l9ls65cAaZNAyZNKm0TSWJnAUh7TZ6sLTyrZrp/XQXA/etGpkwp217HAAC33Sb7m78/MGeODIs5\n" +
                "OWkNU7uVK4GhQ6W4QvfuwHffARcvlr5u98ek7otwmzZtUgBUUFCQCgkJUSEhISo1NVUlJiaqxMRE\n" +
                "pZRSRUVFasiQIaply5YqMDBQ7dix46bvW5ULkUlJSvn4yEVjHx9eMC5r+3alAgPlAnHfvkr9979s\n" +
                "L3OxvcxTUXtlZyv10EOyH3bpolRuru4o9Th+XKlevaQdQkOVysyU56tjH7OlSRzaE1hNuZU/QkJC\n" +
                "QvUFYuP++EOp115TqlYtpby8lEpJKb8N28s8bC/z/Lm9rl5Vau5cpe64Q6n69ZX64AOlCgv1xGZp\n" +
                "RUVKLVqkVIMGStWpo9SUKUpduVJ+u1vZx2wpgWm/D4ys14YNQHCw3A/30kty7at7d91RkaNzdgZe\n" +
                "eQXYtw946CFgyBDg8ceBX3/VHVnNys0FunQBXnwR8PMDsrJkAtBtt+mOTB8mMCrnzBm5ebu4sv76\n" +
                "9cA//8klYsi6tGgBfPMN8PHHUmQgOFim31+9qjuy6lVUBMybJ9WAfvwReP99YNMm4IEHdEemHxMY\n" +
                "mVi1Sg6UBQuA11/nEjFk3ZycpEeSnQ107Qq8+SYQFQXs3q07surx88/Ao49Kj/ORR6TXOWwYUItn\n" +
                "bgBMYHRNQQHwl7/IEGHxEjEzZ3KJGLINTZvKjLzly4H8fCA8HHjrrfI39toKo1FmYoaESHJetAhI\n" +
                "S5NeJ5ViAnNwSgGffSZj6suXS905LhFDtqpXLznhx8XJ9PHWraX4ti3ZtUuOvzFjgOho+f/068db\n" +
                "BirCBObA8vLkAImLA3x95cAZNw6oXVt3ZERV17BhaY/lwgWgbVvg1VeB8+d1R3Zjly7JpIyICOD4\n" +
                "cWDFCll3sEkT3ZFZLyYwB1RUBHz4odwQWrxEzObNcu2LyF489ZRcMxo6VCY+BAYC336rO6qK/fij\n" +
                "DBdOmwa88ALw009ABUWJ6E+YwBzMwYOyRMzgwfJJb98+LhFD9uvOOyV5/fCDVDx56ingb3+T8kvW\n" +
                "4Nw5mZTRrh1w+bLMqvzXv+Q6NN0cE5iDuHoVeOcdICgI2LkT+OgjKTvTsqXuyIhqXtu2ct/U//0f\n" +
                "8OmnMvqwcqXemL75RnqFH3wADB8uHyY7ddIbk61hAnMAe/bIDZ9vvCEHSHY2MHAgLwqTY7n9dpnY\n" +
                "kZEhsxZ79QJiYoATJywbx6lTMimjc2eZ5btpk9R2rF/fsnHYAyYwO3b5MpCQIKtJ5+YCn38OfPUV\n" +
                "UEEhfyKHERoKbNsGTJ0q9z36+wOLF8uM3JqklMz09feXmb9jxsjEqUceqdnfa8+YwOzU1q1AmzbA\n" +
                "xIlAbKxcFO7dm70uIkDKL735ptzwHBAgN0N37gzk5NTM7zt+XHp8zz0HeHsDO3aYrupAVcMEZmf+\n" +
                "+AMYNUrW6zp7FkhNlTF/d3fdkRFZn1atgI0bpVTTli1yTer992WmbnVQSkpd+fsDq1fLLMNt26QX\n" +
                "SLeOCcyOrFsnkzTee09mGe7fL+V1iOj6atWSqfb79slkj+HDpXzTzz/f2vsePizXnPv3l+Nyzx5g\n" +
                "9GjARfsqjPaDCcwOnD4t1eKffFIOjo0bZWaTq+vNf5aIhI8PsGaNXA/76Se5L2vKFCnrZI7CQmDu\n" +
                "XOnNbd0KzJ8vKzvcf3+NhO3QmMBsXHKyDE98/LF8utu9Wz49EpH5nJzkRuLsbOCZZ2SiRWSk3HpS\n" +
                "GdnZck/Xq68Cjz0moyBDhrD4bk3R3qz9+/eHp6cnAgMDK3x9w4YNcHNzQ2hoKEJDQzFx4kQLR2id\n" +
                "/vMfoE8foEcPwNNTxtWnTQPq1tUdGZHta9wY+OILuVfsxAlJYv/4B3DxYsXbG40yKaN1a+CXX+S6\n" +
                "c2oq0Ly5ZeN2NNoT2Isvvoi0tLQbbtOuXTtkZWUhKysL48aNs1Bk1kkpIClJel1ffSUHzY4dMlWe\n" +
                "iKrXs8+WFtOdNk0mX/z4o+k2mZlS/X7sWPlA+dNPwPPPc8avJWhPYI8++igaNmyoOwybcOQI0K0b\n" +
                "8Ne/yuyprCwZ4nDkFVmJalqDBsDChcDatcCVKzJEOGwY8N//yrB9ZKQsR/Tll3Kvpaen7ogdh/YE\n" +
                "Vhnp6ekICQlBly5dsH//ft3hWFxREZCYKPerbNwod+1v2iRLoBCRZTz5pKz8/OqrMjGjcWNgxgyp\n" +
                "rZidLb0vsiyrn9DZpk0b5Obmon79+li9ejV69OiBAwcOVLitwWCAwWAAABQUFFgyzBrz669S9mnT\n" +
                "JqBjR6kif889uqMickxFRdILK8tolJmHZHlW3wNzdXVF/WtFwrp27Qqj0YiTJ09WuG18fDwyMjKQ\n" +
                "kZEBDw8PS4ZZ7a5eBaZPB4KD5VPfxx9L8U8mLyI9Vq+WqfH//Kes4HDqlFz3+uwzuSb973/XfDkq\n" +
                "MmX1CezEiRNQ1/aK7du3o+O27IYAABb1SURBVKioCO52XlZi924gKkpK3XTtKsMTL77Ii8JEOpw8\n" +
                "Kdedu3WT5Vm2bJE19Bo2lFJtGRlAs2ZSqq1nTykbRZahfQixb9++2LBhA06ePAlvb29MmDABxmt3\n" +
                "Dg4ePBjLly9HYmIiXFxcULduXSxbtgxOdnomv3RJZhVOny6ln5Yvl/ppRGR5SslU+ldekfXDxo2T\n" +
                "5Vjq1DHdLiREblh+7z3Zxs9PEtzf/sYPnTVNewJbunTpDV8fNmwYhg0bZqFo9NmyBRgwQMrX9OtX\n" +
                "+gmPiCzv2DHg5ZeBlBSZIv/ddzKcfz0uLrJc0TPPSFWcAQOApUsBg4HD/jXJ6ocQ7d358zKrqW1b\n" +
                "4MIFIC0NWLSIyYtIB6WABQvkmta33wIzZwLp6TdOXmXdfz/w/fcya3jbNrlmNmcOJ3nUFCYwjb79\n" +
                "trT6dXEx0aee0h0VkWP67TeZKv/SS3LD8t69wOuvm198t1at0mLajz8OjBghH1Czs2skbIfGBKbB\n" +
                "77/L+PhTT8l6QD/8IEnszjt1R0bkeAoL5fpVYKBUtfnwQ2D9esDX99bet1kzWTAzKQk4cEDKTL39\n" +
                "dvlp+FR1TGAWtnKlDE98+qnUVsvKkk9nRGR5+/fLisijRgEdOkgvKT6++orvOjkBcXHyvj17yiSP\n" +
                "iAiZuUi3jgnMQk6cAGJiZFZhkybySW/KFK7ISqTDlSsyBb51a+DQIbmX6+uvZbXkmuDpKZM6kpNl\n" +
                "Wn5UFPD3v1+/ODBVDhNYDVNK1hfy95fhhClTgO3b5cAhIssrLn6dkCAfKrOzgb59LTPlPTpaen0D\n" +
                "BsgEkeBgKQ9HVcMEVoNycoDOneUmZH9/GS78xz9YfJdIhwsXZFLGgw/KdeiUFOl5Wbpoz113yfT6\n" +
                "deukNNXjj8uU/bNnLRuHPWACqwFFRTIpIzBQ7u+aN08majzwgO7IiBzThg3S25k1S2YZ7t8PdO+u\n" +
                "N6YOHWSm46hRktACAmQNMao8JrBq9vPPsiLy8OEyOWPfPpkizxVZiSzvzBlg0CCgfXt5vH691DJ0\n" +
                "c9MbV7F69SSpbtkiMT39tKwldp1yr/QnPK1WE6NRrm+FhMiY+uLFwJo1gI+P7siIHNOqVdKrWbBA\n" +
                "hg737ClNZNYmKgrYuVOuy33xhZSjWraMxYFvhgmsGuzaJYvajRkjF2l/+gl44QXWQSPSoaAA+Mtf\n" +
                "ZIiwQQOppDFzpvR2rFnt2sD48bLC8z33yMSSHj2A/HzdkVkvJrBbcPGiTMqIiJBp8itWyJIKjRvr\n" +
                "jozI8SglkzL8/KQQ9oQJkgwiI3VHZp6gIEm677wjq0D7+wMffcTeWEWYwKroxx+l3My0aVJ8t/hG\n" +
                "RSKyvLw8Gf2Ii5MKGrt2yU3DtWvrjqxqnJ2B116TYc82beTm6ieekHvWqBQTmJnOnQOGDQPatZOb\n" +
                "IdeuBRYulKEKIrKsoiIp/eTvL9PS330X2LxZrn3ZA19fmXhiMEhvMihI/o8sDiyYwMyQliZT4z/4\n" +
                "QCrI790rxT+JyPIOHpReyeDBMoy/b5+slOzsrDuy6uXkJFP/s7PlfPPaa8DDD8v/19ExgVXCqVMy\n" +
                "TNilC3DHHfIJb/ZsoH593ZEROZ6rV+X6UFCQzNz76CNZr6tlS92R1SwvLylFtXSpVM5v00au8zly\n" +
                "cWDtCax///7w9PREYGBgha8rpTB8+HD4+voiODgYO3futFhsSsnFYH9/uTj81lsytv7QQxYLgYjK\n" +
                "2LtXeh9vvAF06iS9koEDHWfGr5MTEBsrM52fe05mLYaFSXk6h6Q027hxo8rMzFQBAQEVvp6amqo6\n" +
                "d+6sioqKVHp6uoqMjKzU+4aFhZkdS1KSUj4+SgEJystLqfBwpQClwsKUysoy++3sXtn28vGRx3R9\n" +
                "bC/zlG2v5s2VevZZpVxclPLwUOrzz5UqKtIdoX5ff62Ul5dStWopNWqUUgsX3vo+VpVzpy7aE5hS\n" +
                "Sh0+fPi6CSw+Pl599tlnJY/vv/9+dezYsZu+p7l/hKQkperVk4QFfHXtq1KxsUoZjWa9lUMwba8E\n" +
                "BchjnpQrZtpek9leN2HaXh+VHI+PPKLUyZO6o7MuZ84oNXiwtI+T060fk7aUwLQPId5Mfn4+mjVr\n" +
                "VvLY29sb+TVwZ9+YMVLsUzxT8nx6uvkrsjoC0/Z6A4A8HjNGW0hWzbS9/g8A2+tGTNurf8nzeXmA\n" +
                "u7uWkKyWqyuQmCj3n5beK3Y3APvfx+zq1GwwGGAwGAAABQUFZv3skSNlHxkBTAGgkJsr48xkKje3\n" +
                "+LsHAXS+9v0R5OamYPx4FnL7s9L2CgLQC8D7AE5x/7qO0va6B0A/AIsA5LC9buA//wGAxgBeBnC6\n" +
                "5HnTc5ud0d0FVMo6hhBl3Lj4n7Hkex8fs97GYZi2l+m/yZOVunJFd4TW5Xrtxf2rYmwv85m22edV\n" +
                "bjMOIVaj6OhofPLJJ1BKYevWrXBzc0PTpk2r/fdMnly+Vlq9evI8lVdRe9WtW1oTMjJSZmyS4P5l\n" +
                "HraX+SZPLr/Cu923me4MGhsbq5o0aaJcXFyUl5eXWrBggUpMTFSJiYlKKaWKiorUkCFDVMuWLVVg\n" +
                "YKDasWNHpd63qrMQXV2lB8ZZYjeXlKRUgwbyKa9Zs9L2WrlSqSZNlHJ2VurNN5W6cEFvnNYiKUmp\n" +
                "Ro2kve6+m/vXzSQlKeXpKe3VuDHbqzKmTSvtgXEWog2r6h9h9GilnJ057bCy3n1XDpjTp02f/9//\n" +
                "lOrfX167/36lNm3SE5+1WbJE2uSXX3RHYhvWrZP22rhRdyS2Yd8+aa+YmM+r/B62lMCsfgiRbFOD\n" +
                "BlIjcu1aqRTQrp3UkDx3TndkRGQvmMCoRj35pNRsGzFCakgGBkpNSSKiW8UERjXujjuA996TGpJ3\n" +
                "3CE1Jfv1kxqTRERVxQRGFvPQQzIzcexYqS3p7y8LgHKhPiKqCiYwsqg6dYCJE4GMDKBZM6B3b1kI\n" +
                "9Phx3ZERka1hAiMtQkKArVuBGTPkmpifH/Cvf7E3RkSVxwRG2ri4yLIYu3dLQhswQJbIOHxYd2RE\n" +
                "ZAuYwEi7++8Hvv9eCpJu2yYzFefM4bLpRHRjTGBkFWrVkqXh9+8HHn9cpt23aycLFhIRVYQJjKxK\n" +
                "s2bAqlVAUhLw669A69bApEmOvWw6EVWMCYysjpMTEBcnva+ePWXafUSEzFwkIirGBEZWy9MTWLoU\n" +
                "SE4GTp4EoqKAv/8duHhRd2REZA2YwMjqRUfLtbEBA4CZM4HgYGDjRt1REZFuTGBkE+66CzAYgHXr\n" +
                "gKIimejx8svA2bO6IyMiXZjAyKZ06ADs3QuMGiUJLSAAWL1ad1REpINVJLC0tDS0atUKvr6+mDZt\n" +
                "WrnXFy1aBA8PD4SGhiI0NBQLFizQECVZi3r1gFmzgC1bADc3oFs34Pnn5ToZETkO7QmssLAQQ4cO\n" +
                "xZo1a5CdnY2lS5ciu4Kbf/r06YOsrCxkZWVh4MCBGiIlaxMVBezcCSQkAF98IeWoli1jOSoiR6E9\n" +
                "gW3fvh2+vr5o2bIlateujdjYWCQnJ+sOi2xE7drA+PFAZiZwzz1A375Ajx5Afr7uyIiopmlPYPn5\n" +
                "+WjWrFnJY29vb+RXcPZZsWIFgoODERMTg6NHj1oyRLIBQUFAejrwzjuyCrS/P/DRR+yNEdkz7Qms\n" +
                "Mrp3746cnBzs2bMHHTt2RL9+/SrczmAwIDw8HOHh4SgoKLBwlKSbszPw2mvAnj1AmzZAfDzwxBPA\n" +
                "oUO6IyOimqA9gXl5eZn0qPLy8uDl5WWyjbu7O+rUqQMAGDhwIDIzMyt8r/j4eGRkZCAjIwMeHh41\n" +
                "FzRZNV9fYP16maWYmSm9s3ffZXFgInujPYFFRETgwIEDOHz4MK5cuYJly5YhOjraZJvjZVY7TElJ\n" +
                "gZ+fn6XDJBvj5AS89JKUo3rySemZPfwwsG+f7siIqLpoT2AuLi6YN28ennrqKfj5+aF3794ICAjA\n" +
                "uHHjkJKSAgCYO3cuAgICEBISgrlz52LRokV6gyab4eUlpaiWLgV++02GFidMYHFgInvgojsAAOja\n" +
                "tSu6du1q8tzEiRNLvp86dSqmTp1q6bDITjg5AbGx0hN79VWZtbh8ObBwIRAZqTs6Iqoq7T0wIktp\n" +
                "1AhYsgT4+mvg99+Bhx4CXn8duHBBd2REVBVMYORwnn5aigPHx0tFj6AgWRGaiGwLExg5JDc3IDER\n" +
                "2LBBVoPu0AEYNAg4c0Z3ZERUWUxg5NAeewzYvRt44w1gwQK5Afrrr3VHRUSVwQRGDq9ePWDGDGDb\n" +
                "NsDdXdYf69sX4L3wRNaNCYzomvBwICMDmDgRWLFCigN/9hnLURFZKyYwojJq1wbGjgV27ZKKHnFx\n" +
                "QPfuAMtvElkfJjCiCgQEAJs3A++9JzMUAwKADz+U1aCJyDowgRFdh7MzMGKErAAdGQkMHiyzFQ8c\n" +
                "0B0ZEQFMYEQ31bKlLNGycCGQlQUEBwMzZwJXr+qOjMixMYERVYKTE9C/vxQHfuop4O9/l0oee/bo\n" +
                "jozIcTGBEZnh7ruBL78EvvgCOHIECAsDxo0DLl/WHRmR42ECIzKTkxPw3HPSG+vbF3j7balyv3Wr\n" +
                "7siIHAsTGFEVubsDn3wCrF4NnDsn642NHAn88YfuyIgcAxMY0S3q0kUWynz5ZWD2bCkO/N13uqMi\n" +
                "sn9MYETVwNUVmD8f+OEHwMUF6NgRGDAAOH1ad2RE9ssqElhaWhpatWoFX19fTJs2rdzrly9fRp8+\n" +
                "feDr64uoqCjk5ORYPkiiSmjXTooDv/kmsHixFAf+6ivdURHZJ+0JrLCwEEOHDsWaNWuQnZ2NpUuX\n" +
                "Ijs722SbhQsXokGDBjh48CBGjhyJ0aNH10gsS5bIEhuFhUCLFvKYrm/JEpnAAMiwGdtL1K0LTJ0q\n" +
                "xYE9PYFnnwV69wY++EBWhAaA9u3ZXjezZIlMkgGk/dheN7dqlXxdvtxBzmFKsy1btqhOnTqVPJ4y\n" +
                "ZYqaMmWKyTadOnVSW7ZsUUopZTQalbu7uyoqKrrh+4aFhZkVR1KSUvXqKSWlW40KkMdJSWa9jcMw\n" +
                "bS/F9rqOK1eUmjxZKRcX07Zie90Y9y/zJSUpdfvtxe31eZXbzNxzp04uuhNofn4+mjVrVvLY29sb\n" +
                "27Ztu+42Li4ucHNzw6lTp9CoUaNqi2PMmLJLyzsDkMeDBgHffFNtv8ZurFxZtr3EhQvSjnFxemKy\n" +
                "RrfdBvzf/8n1sWPHTF9je12f6fEoeDze2MqVwKVLps/Z+z6mPYFVJ4PBAIPBAAAoMHMxpyNHyj4q\n" +
                "AHAbAJkSzQUOyzOdKp4HYCUAhdxcYPx4LSFZNUleTgAiATQGsAaAke11Hbm5xd+5AugJwA0Aj8cb\n" +
                "KT0mjQD2AugN4M/nNvuiPYF5eXnhaJm1KvLy8uDl5VXhNt7e3rh69SrOnDkDd3f3cu8VHx+P+Ph4\n" +
                "AEB4eLhZcTRvXvag8Sx53scH4JyR8lq0KNteDQAEAZD24gm5vEWLyrYXALQBwPa6nvLtJXg8Xp/p\n" +
                "Mfl2yfPNm+uIxjK0T+KIiIjAgQMHcPjwYVy5cgXLli1DdHS0yTbR0dFYvHgxAGD58uXo0KEDnJyc\n" +
                "qjWOyZNlZd6y6tWT56k8tpd52F7mYXuZzyHbTPdFOKWUSk1NVffdd59q2bKlmjRpklJKqbFjx6rk\n" +
                "5GSllFIXL15UMTEx6t5771URERHq0KFDN33PqlyITEpSysdHKScn+coLxjfG9jIP28s8bC/zVUeb\n" +
                "2dIkDiel7HPB9PDwcGRkZOgOg4jIptjSuVP7ECIREVFVMIEREZFNYgIjIiKbxARGREQ2iQmMiIhs\n" +
                "kt3OQmzUqBFatGhRpZ8tKCiAh4dH9QZUDRiXeRiXeRiX+aw1tluJKycnBydPnqzmiGqG3SawW2Gt\n" +
                "00gZl3kYl3kYl/msNTZrjau6cQiRiIhsEhMYERHZJOfx41lKtCJhYWG6Q6gQ4zIP4zIP4zKftcZm\n" +
                "rXFVJ14DIyIim8QhRCIiskkOncDS0tLQqlUr+Pr6Ytq0aeVev3z5Mvr06QNfX19ERUUhx0ILEd0s\n" +
                "rkWLFsHDwwOhoaEIDQ3FggULajym/v37w9PTE4GBgRW+rpTC8OHD4evri+DgYOzcubPGY6pMXBs2\n" +
                "bICbm1tJW02cONEicR09ehTt27eHv78/AgICMGfOnHLb6GizysSlo80uXbqEyMhIhISEICAgAAkJ\n" +
                "CeW20XE8ViYuHcdjscLCQrRu3RpPP/10udd0nb8sSlcZfN2uXr2qWrZsqQ4dOqQuX76sgoOD1f79\n" +
                "+022mT9/vho0aJBSSqmlS5eq3r17W0VcH3/8sRo6dGiNx1LWxo0bVWZmpgoICKjw9dTUVNW5c2dV\n" +
                "VFSk0tPTVWRkpFXE9f3336tu3bpZJJayjh07pjIzM5VSSp09e1bdd9995f6OOtqsMnHpaLOioiJ1\n" +
                "7tw5pZRSV65cUZGRkSo9Pd1kGx3HY2Xi0nE8Fps1a5bq27dvhX8vHe1laQ7bA9u+fTt8fX3RsmVL\n" +
                "1K5dG7GxsUhOTjbZJjk5Gf369QMAxMTEYN26dVA1fMmwMnHp8Oijj6Jhw4bXfT05ORkvvPACnJyc\n" +
                "8OCDD+L06dM4fvy49rh0adq0Kdq0kVWX77zzTvj5+SE/P99kGx1tVpm4dHByckL9+vUBAEajEUaj\n" +
                "sdyitTqOx8rEpUteXh5SU1MxcODACl/X0V6W5rAJLD8/H82aNSt57O3tXe5ALruNi4sL3NzccOrU\n" +
                "Ke1xAcCKFSsQHByMmJgYHD16tEZjqozKxq1Deno6QkJC0KVLF+zfv9/ivz8nJwe7du1CVFSUyfO6\n" +
                "2+x6cQF62qywsBChoaHw9PREx44db9heljoeKxMXoOd4HDFiBGbMmIFatSo+jetqL0ty2ARmy7p3\n" +
                "746cnBzs2bMHHTt2LPmUReW1adMGubm52L17N1555RX06NHDor///Pnz6NWrF2bPng1XV1eL/u4b\n" +
                "uVFcutrM2dkZWVlZyMvLw/bt27Fv3z6L/N6buVlcOo7HVatWwdPT0yGmyt+IwyYwLy8vk09KeXl5\n" +
                "8PLyuu42V69exZkzZ+Du7q49Lnd3d9SpUwcAMHDgQGRmZtZoTJVRmbh1cHV1LRkC6tq1K4xGo8Xq\n" +
                "vBmNRvTq1QtxcXHo2bNnudd1tdnN4tLZZgBw1113oX379khLSzN5XsfxWJm4dByPmzdvRkpKClq0\n" +
                "aIHY2FisX78ezz//vMk2utvLEhw2gUVERODAgQM4fPgwrly5gmXLliE6Otpkm+joaCxevBgAsHz5\n" +
                "cnTo0KHGx78rE1fZ6yQpKSnw8/Or0ZgqIzo6Gp988gmUUti6dSvc3NzQtGlT3WHhxIkTJeP+27dv\n" +
                "R1FRkUUOYqUUBgwYAD8/P4waNarCbXS0WWXi0tFmBQUFOH36NADg4sWLWLt2LR544AGTbXQcj5WJ\n" +
                "S8fxOHXqVOTl5SEnJwfLli1Dhw4dkJSUZLKNjvayOG3TR6xAamqquu+++1TLli3VpEmTlFJKjR07\n" +
                "ViUnJyullLp48aKKiYlR9957r4qIiFCHDh2yirjefPNN5e/vr4KDg9Xjjz+ufvrppxqPKTY2VjVp\n" +
                "0kS5uLgoLy8vtWDBApWYmKgSExOVUjJba8iQIaply5YqMDBQ7dixo8Zjqkxc77//fklbRUVFqc2b\n" +
                "N1skrk2bNikAKigoSIWEhKiQkBCVmpqqvc0qE5eONtu9e7cKDQ1VQUFBKiAgQE2YMEEppf94rExc\n" +
                "Oo7HssrOGtXdXpbGShxERGSTHHYIkYiIbBsTGBER2SQmMCIisklMYEREZJOYwIiIyCYxgRERkU1i\n" +
                "AiMiIpvEBEZERDaJCYyIiGwSExgREdkkJjAiIrJJTGBERGSTmMCIiMgmMYEREZFNYgIjIiKbxARG\n" +
                "REQ2iQmMiIhsEhMYERHZJCYwIiKySUxgRERkk/4f81O/ogNP/WIAAAAASUVORK5CYII=";
        String targetPath="/dva.png";
        base64ToImg(base64,targetPath);

    }
}
