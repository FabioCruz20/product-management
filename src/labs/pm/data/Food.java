/*
 * Copyright (C) 2021 Fabio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Fabio
 */
public class Food extends Product {

    private LocalDate bestBefore;

    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    /**
     * Get the value of the best before date for the product
     *
     * @return the value of bestBefore
     */
    @Override
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    /**
     * A 10% discount is applied if current date is the best before date.
     *
     * @return a {@link java.math.BigDecimal BigDecimal} discount of 10% or zero
     * depending on current date.
     */
    @Override
    public BigDecimal getDiscount() {
                
        return (LocalDate.now().equals(bestBefore)) ? 
                super.getDiscount() :  BigDecimal.ZERO;
    }
    
    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(), getName(), getPrice(), newRating, getBestBefore());
    }
    
}
