#******************************************************************************#
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: wto <marvin@42.fr>                         +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/10/20 21:18:07 by wto               #+#    #+#              #
#    Updated: 2018/10/20 21:18:08 by wto              ###   ########.fr        #
#                                                                              #
#******************************************************************************#

NAME		=	avaj_launcher.simulator.Simulator
COMPILER	=	javac
FLAGS		=	-sourcepath
SRCFILE		=	sources.txt
RM			=	/bin/rm
SCENARIO	=	scenario.txt
JAVA		=	java
OUTPUT		=	simulation.txt

all:
	find . -name *.java > $(SRCFILE)
	$(COMPILER) -d . $(FLAGS) @$(SRCFILE)

clean:
	$(RM) $(SRCFILE)

fclean: clean
	$(RM) *.class

run:
	$(JAVA) $(NAME) $(SCENARIO)

re: fclean all
