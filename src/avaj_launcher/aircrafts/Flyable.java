// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Flyable.java                                       :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/21 19:09:50 by wto               #+#    #+#             //
//   Updated: 2018/11/21 19:09:51 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.aircrafts;

import avaj_launcher.simulator.WeatherTower;

public interface Flyable
{
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
