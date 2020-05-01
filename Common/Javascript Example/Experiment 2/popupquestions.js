class PopUpQuestion{
    constructor(){
        this.popUpCounter = 0;
        this.questions = [];
        this.questionIndex = 0;
    }
    setPopUpCounter(popUpCounter){
        this.popUpCounter = popUpCounter;
    }
    count(){
        this.popUpCounter--;
        if(this.popUpCounter === 0){
            return true;
        }
        return false;
    }
    pushQuestion(question){
        this.questions.push(question);
    }
    popQuestion(){
        if(this.questionIndex > this.questions.length - 1){
            return false;
        }
        var question = this.questions[this.questionIndex];
        this.questionIndex += 1;
        return question;
    }
    getCurrentQuestion(){
        return this.questions[this.questionIndex];
    }
    incrementIndex(){
        this.questionIndex +=1 ;
    }
    decrementIndex(){
        this.questionIndex -=1 ;
    }
    questionUnderFlow(){
        if(this.questionIndex > this.questions.length - 1){
            return true;
        }
        return false;
    }
    popUpCounterSet(){
        if(this.popUpCounter === 0){
            return false;
        }else{
            return true;
        }
    }
}
class Question{
    constructor(question, options, correctOption){
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
    getQuestion(){
        return this.question;
    }
    getOptions(){
        return this.options;
    }
    getCorrectOption(){
        return this.correctOption;
    }
}