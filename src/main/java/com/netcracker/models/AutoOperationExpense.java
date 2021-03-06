package com.netcracker.models;

import com.netcracker.models.enums.CategoryExpense;

public class AutoOperationExpense extends AbstractAutoOperation {
    private CategoryExpense categoryExpense;

    public static class Builder extends BaseBuilderAO<AutoOperationExpense, Builder> {

        public Builder categoryExpense(CategoryExpense expense) {
            actualClass.setCategoryExpense(expense);
            return this;
        }

        @Override
        protected AutoOperationExpense getActual() {
            return new AutoOperationExpense();
        }

        @Override
        protected Builder getActualBuilder() {
            return this;
        }
    }

    public CategoryExpense getCategoryExpense() {
        return categoryExpense;
    }

    public void setCategoryExpense(CategoryExpense categoryExpense) {
        this.categoryExpense = categoryExpense;
    }

    @Override
    public String toString() {
        return "AutoOperationExpense [id=" + this.getId() + ", dayOfMonth=" + this.getDayOfMonth() + ", amount=" + this.getAmount() +
                ", categoryExpense=" + this.getCategoryExpense() + ", date=" + this.getDate() + "]";
    }

}
