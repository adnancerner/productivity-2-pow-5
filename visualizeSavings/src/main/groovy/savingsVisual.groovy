// cerner_2^5_2019

package visualizesavings

import groovy.swing.SwingBuilder 
import groovy.beans.Bindable 
import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.BorderLayout

@Bindable
class InterestCalculator { 
    String rate, years, amount
    float total=0
    void setTotal() {
        total=0
        for (def i=0;i<(Integer.parseInt(years)*26);i++) {
            total += (total * (Float.parseFloat(rate)/2600)) + Integer.parseInt(amount)
        }
    }
}
   
def interestCalc = new InterestCalculator(rate: '5', years: '10', amount: '0')
   
def swingBuilder = new SwingBuilder()
swingBuilder.edt {
    lookAndFeel 'nimbus'
    frame(title: 'Savings Calculator', size: [500, 300],
            show: true, locationRelativeTo: null,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        borderLayout(vgap: 5)
         
        panel(constraints: BorderLayout.CENTER,
                border: compoundBorder([emptyBorder(10), titledBorder('Please adjust the values')])) {
            tableLayout {
                tr {    td {    label 'Interest rate:'     }
                    td {    textField interestCalc.rate, id: 'interestField', columns: 20  }
                }
                tr {    td {    label 'Years:'     }
                    td {    textField id: 'yearsField', columns: 3, text: interestCalc.years    }
                }
                tr {    td {    label 'Bi-weekly contribution:'     }
                    td {    textField id: 'amountField', columns: 20, interestCalc.amount  }
                }
                tr {    td {    label 'Total accumulation'     }
                    td {    textField id: 'totalField', columns: 20 }
                }
            }
        }
         
        panel(constraints: BorderLayout.SOUTH) {
            button text: 'Get Total', actionPerformed: {
                interestCalc.setTotal()
                totalField.setText("Total over $years years would be: $total")
            }
        }
         
        // Binding of textfield's to interestCalc object.
        bean interestCalc,
            rate: bind { interestField.text },
            years: bind { yearsField.text },
            amount: bind { amountField.text }
    } 
}